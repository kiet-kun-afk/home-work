import java.util.HashMap;
import java.util.Map;

public class OccurrenceCounter {
    public static Map<Integer, Integer> countOccurrences(int n) {
        Map<Integer, Integer> occurrences = new HashMap<>();

        // Số 1 luôn xuất hiện n - 3 lần
        occurrences.put(1, n - 3);

        // Số 2 luôn xuất hiện 3 lần
        occurrences.put(2, 3);

        // Số 3 luôn xuất hiện 2 lần
        occurrences.put(3, 2);

        // Các số còn lại xuất hiện 1 lần
        for (int i = 4; i <= n; i++) {
            occurrences.put(i, 1);
        }

        return occurrences;
    }

    public static void main(String[] args) {
        // Lấy giá trị của n từ người dùng hoặc từ bất kỳ nguồn nào khác
        int n = 10; // Ví dụ từ 1 đến 9
        Map<Integer, Integer> result = countOccurrences(n);
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            System.out.println("Số " + entry.getKey() + " xuất hiện: " + entry.getValue() + " lần");
        }
    }
}
