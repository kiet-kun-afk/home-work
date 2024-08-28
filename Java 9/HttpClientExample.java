import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientExample {
    public static void main(String[] args) throws Exception {
        // tạo đối tượng HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();

        // tạo đối tượng HttpRequest sử dụng Builder
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("https://www.example.com"))
                .GET()
                .build();

        // gửi HTTP request và nhận HTTP response
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        // in thông tin về HTTP Response 
        System.out.println("Status Code: " + httpResponse.statusCode());
        System.out.println("Response Body: " + httpResponse.body());
    }
}
