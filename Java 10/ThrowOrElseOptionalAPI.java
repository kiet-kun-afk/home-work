import java.util.stream.Stream;

public class ThrowOrElseOptionalAPI {
    public static void main(String[] args) {
        // tạo một Stream có 3 chuỗi: "java", "python", "golang"
        String result = Stream.of("java", "python", "golang")
                .filter(s -> Character.isDigit(s.charAt(0)))
                .findAny() // trả về một optional
                .orElseThrow();
        System.out.println(result);
    }
}
