import java.util.*;

public class Main {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số đỉnh: ");
        int n = scanner.nextInt(); // Số lượng đỉnh
        System.out.println("Nhập số cạnh: ");
        int m = scanner.nextInt(); // Số lượng cạnh
        System.out.println("Nhập đỉnh bắt đầu: ");
        int s = scanner.nextInt(); // Đỉnh bắt đầu
        System.out.println("Nhập đỉnh kết thúc: ");
        int t = scanner.nextInt(); // Đỉnh kết thúc

        adj = new ArrayList[n + 1]; // Danh sách kề
        visited = new boolean[n + 1]; // Mảng đánh dấu đỉnh đã thăm
        parent = new int[n + 1]; // Mảng lưu đỉnh cha của mỗi đỉnh

        // Khởi tạo danh sách kề
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Đọc các cạnh và thêm vào danh sách kề
        for (int i = 0; i < m; i++) {
            System.out.println("Lần nhập thứ: " + i);
            System.out.println("Nhập u: ");
            int u = scanner.nextInt();
            System.out.println("Nhập v: ");
            int v = scanner.nextInt();
            adj[u].add(v);
        }

        // Gọi DFS từ đỉnh s
        dfs(s);

        // In đường đi từ s tới t nếu có
        if (!visited[t]) {
            System.out.println("-1"); // Không có đường đi
        } else {
            ArrayList<Integer> path = new ArrayList<>();
            int current = t;
            while (current != s) {
                path.add(current);
                current = parent[current];
            }
            path.add(s);
            Collections.reverse(path); // Đảo ngược danh sách để in đúng thứ tự
            for (int vertex : path) {
                System.out.print(vertex + " ");
            }
        }
    }

    // DFS từ đỉnh u
    static void dfs(int u) {
        visited[u] = true;
        for (int v : adj[u]) {
            if (!visited[v]) {
                parent[v] = u; // Lưu đỉnh cha của v
                dfs(v);
            }
        }
    }
}
