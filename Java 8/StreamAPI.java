import java.util.Arrays;
import java.util.List;

public class StreamAPI {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "orange");
        long count = words.stream().filter(word -> word.length() > 5).count();
        System.out.println("Count: " + count);
    }
}
