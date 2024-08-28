import java.io.BufferedReader;
import java.net.http.HttpClient;
import java.util.List;

/**
 * LocalVarInference
 * 
 * @author https://viblo.asia/p/tat-tan-tat-tu-jdk-8-den-jdk-21-MG24B63B4z3#_1-local-variable-type-inference-var-19
 */
public class LocalVarInference {

    /**
     * Cho phép: chỉ khi sử dụng làm biến cục bộ
     * Không cho phép: ở bất kỳ nơi nào khác (trường của lớp, tham số của phương thức, vv.)
     * Sử dụng 'var' một cách có trách nhiệm!
     *
     * Sử dụng:
     *  - khi rõ ràng về kiểu dữ liệu (string, int)
     *  - để rút gọn kiểu dữ liệu quá dài và phức tạp
     *
     * Không sử dụng:
     *  - khi giá trị trả về không rõ ràng (var data = service.getData();)
     */

    public static void main(String[] args) {
        // Cho phép, nhưng mang lại ít lợi ích
        var b = "b";
        var c = 5; // int
        var d = 5.0; // double
        var httpClient = HttpClient.newHttpClient();

        // Suy luận phức tạp hơn :)
        var list = List.of(1, 2.0, "3");

        // Lợi ích trở nên rõ ràng hơn với các kiểu dữ liệu có tên dài
        var reader = new BufferedReader(null);
        // so với
        BufferedReader reader2 = new BufferedReader(null);
    }
}