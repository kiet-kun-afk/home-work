import java.sql.Date;
import java.sql.Time;

public class DateAndTime {
    public static void main(String[] args) {
        // Tạo đối tượng Date cho requestDate
        Date requestDate = Date.valueOf("2024-05-30"); // yyyy-MM-dd

        // Tạo đối tượng Time cho requestTime
        Time requestTime = Time.valueOf("15:30:00"); // HH:mm:ss

        // Tạo đối tượng của lớp chứa requestDate và requestTime (ví dụ: Request)
        Request request = new Request();
        request.setRequestDate(requestDate);
        request.setRequestTime(requestTime);

        // In ra để kiểm tra
        System.out.println("Request Date: " + request.getRequestDate());
        System.out.println("Request Time: " + request.getRequestTime());
    }
}

class Request {
    private Date requestDate;
    private Time requestTime;

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Time getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Time requestTime) {
        this.requestTime = requestTime;
    }
}
