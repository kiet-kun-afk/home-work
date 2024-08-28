import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsClass {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        String result = names.stream().collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
