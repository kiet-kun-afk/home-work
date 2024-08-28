import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

class TestBigDecimal {
    public static String formatCurrency(double value) {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        format.setMinimumFractionDigits(1);
        format.setMaximumFractionDigits(1);
        format.setRoundingMode(RoundingMode.HALF_EVEN);
        return format.format(value);
    }

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(0.1);
        System.out.println("bigDecimal = " + formatCurrency(bigDecimal.doubleValue()));

        double bigDouble = 0.1;
        System.out.println("bigDouble = " + bigDouble);
    }
}
