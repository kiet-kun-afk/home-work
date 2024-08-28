import java.util.*;

public class Loang {
    static int[][] matrix;
    static boolean[][] visited;
    static int rows, cols;

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số hàng của ma trận: ");
        rows = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận: ");
        cols = scanner.nextInt();

        matrix = new int[rows][cols];
        visited = new boolean[rows][cols];

        System.out.println("Nhập ma trận:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int countComponents = countConnectedComponents();
        System.out.println("Số lượng thành phần liên thông: " + countComponents);
    }

    static int countConnectedComponents() {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    static void bfs(int row, int col) {
        int[] dr = { -1, 0, 1, 0 }; // Các hướng di chuyển
        int[] dc = { 0, 1, 0, -1 };
        Queue<Integer> queueR = new LinkedList<>();
        Queue<Integer> queueC = new LinkedList<>();
        queueR.add(row);
        queueC.add(col);
        visited[row][col] = true;

        while (!queueR.isEmpty()) {
            int r = queueR.poll();
            int c = queueC.poll();

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (isValid(nr, nc) && matrix[nr][nc] == 1 && !visited[nr][nc]) {
                    queueR.add(nr);
                    queueC.add(nc);
                    visited[nr][nc] = true;
                }
            }
        }
    }

    static boolean isValid(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
