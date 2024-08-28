import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIImprovementsExample {
    public static void main(String[] args) {
        // Ví dụ 1: takeWhile
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> lessThanFive = numbers.stream()
                .takeWhile(n -> n < 5)
                .collect(Collectors.toList());

        System.out.println("Số nhỏ hơn 5: " + lessThanFive);

        // Ví dụ 2: dropWhile
        List<Integer> greaterThanThree = numbers.stream()
                .dropWhile(n -> n <= 3)
                .collect(Collectors.toList());

        System.out.println("Số lớn hơn 3: " + greaterThanThree);

        // Ví dụ 3: ofNullable
        String value1 = "Xin chào";
        String value2 = null;

        // Ví dụ với giá trị không rỗng
        Stream.ofNullable(value1)
                .findFirst()
                .ifPresentOrElse(v -> System.out.println("Ví dụ ofNullable - Giá trị không rỗng: " + v),
                        () -> System.out.println("Ví dụ ofNullable - Giá trị rỗng"));

        // Ví dụ với giá trị rỗng
        Stream.ofNullable(value2)
                .findFirst()
                .ifPresentOrElse(v -> System.out.println("Ví dụ ofNullable - Giá trị không rỗng: " + v),
                        () -> System.out.println("Ví dụ ofNullable - Giá trị rỗng"));

        // Ví dụ của luồng an toàn với giá trị null
        List<String> names = Arrays.asList("Alice", "Bob", null, "Charlie", null, "David");
        List<String> nonNullNames = names.stream()
                .flatMap(name -> StreamAPIImprovementsExample.nullSafeStream(name))
                .collect(Collectors.toList());

        System.out.println("Các tên không rỗng: " + nonNullNames);
    }

    // Phương thức hỗ trợ để tạo một luồng từ một giá trị có thể là null
    private static <T> java.util.stream.Stream<T> nullSafeStream(T value) {
        return value == null ? java.util.stream.Stream.empty() : java.util.stream.Stream.of(value);
    }
}
