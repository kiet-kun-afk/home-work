package lock.distributed;

import lombok.SneakyThrows;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

class DistributedLockWithRedisson {
    // ...
    static String USER_ID = "A";

    static Map<String, Integer> USERS = new HashMap<>() {
        {
            put(USER_ID, 1000);
        }
    };

    static RedissonClient redissonClient;

    static {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");
        redissonClient = Redisson.create(config);
    }

    public static void main(String[] args) {
        //
        CompletableFuture.allOf(
                CompletableFuture.runAsync(() -> lock(DistributedLockWithRedisson::fundOut)),
                CompletableFuture.runAsync(() -> lock(DistributedLockWithRedisson::fundTransfer))).join();

        // {A=500}
        System.out.println(USERS);
    }

    static void fundOut() {
        Integer balance = getBalance(USER_ID);
        balance = balance - 200;
        updateBalance(USER_ID, balance);
    }

    static void fundTransfer() {
        Integer balance = getBalance(USER_ID);
        balance = balance - 300;
        updateBalance(USER_ID, balance);
    }

    @SneakyThrows
    static Integer getBalance(String userId) {
        Integer balance = USERS.get(userId);
        Thread.sleep(1000L);
        return balance;
    }

    static void updateBalance(String userId, Integer balance) {
        USERS.put(userId, balance);
    }

    static void lock(Runnable runnable) {
        RLock lock = redissonClient.getLock(USER_ID);

        try {
            // Try to acquire the lock with a timeout of 3 seconds and lease time of 4 seconds
            try {
                if (lock.tryLock(3, 4, TimeUnit.SECONDS)) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }
    // ...
}