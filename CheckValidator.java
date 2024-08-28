import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CheckValidator {
    // private static final String PATTERN = "^[^\\s][^\\s]{6,14}[^\\s]$";
    private static final String PATTERN = "^(03|05|07|08|09)\\d{8}$";

    public static boolean validateCheck(String input) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String input = "0341223424";

        if (validateCheck(input)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
