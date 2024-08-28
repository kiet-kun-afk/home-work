/**
 * TestRandom
 */
public class TestRandom {

    public static void main(String[] args) {
        double random = Math.random();
        double rate = 0.138;
        if (random <= rate) {
            System.out.println("Successfully!");
        } else {
            System.out.println("Failed!");
        }
    }
}
