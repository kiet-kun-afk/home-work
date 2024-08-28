import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateConverter {
    public static void main(String[] args) {
        String dateStr = "2024-05-29T00:00:00";
        ZonedDateTime date = ZonedDateTime.parse(dateStr,
                DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.of("Asia/Ho_Chi_Minh")));
        System.out.println(date.withZoneSameInstant(ZoneId.of("UTC")));
    }
}
