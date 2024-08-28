import java.time.LocalDate;
import java.time.LocalTime;

public class NewDateAndTimeAPI {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);

        // Create an instance of Request
        NewDateAndTimeAPI.Request request = new NewDateAndTimeAPI().new Request();

        // Create LocalDate and LocalTime objects
        LocalDate requestDate = LocalDate.of(2024, 5, 30);
        LocalTime requestTime = LocalTime.of(15, 30);

        // Set the values in the Request object
        request.setRequestDate(requestDate);
        request.setRequestTime(requestTime);

        // Print the values to check
        System.out.println("Request Date: " + request.getRequestDate());
        System.out.println("Request Time: " + request.getRequestTime());
    }

    // Request class moved outside of NewDateAndTimeAPI
    class Request {
        private LocalDate requestDate;
        private LocalTime requestTime;

        public LocalDate getRequestDate() {
            return requestDate;
        }

        public void setRequestDate(LocalDate requestDate) {
            this.requestDate = requestDate;
        }

        public LocalTime getRequestTime() {
            return requestTime;
        }

        public void setRequestTime(LocalTime requestTime) {
            this.requestTime = requestTime;
        }
    }
}