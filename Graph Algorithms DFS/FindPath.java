import java.util.*;

public class FindPath {

    static int n, m, s, t;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("input n: ");
        n = scanner.nextInt();
        System.out.println("input m: ");
        m = scanner.nextInt();
        System.out.println("input s: ");
        s = scanner.nextInt();
        System.out.println("input t: ");
        t = scanner.nextInt();

        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        visited = new boolean[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i < m; i++) {
            System.out.println("Lần nhập thứ: " + i);
            System.out.println("input u: ");
            int u = scanner.nextInt();
            System.out.println("input v: ");
            int v = scanner.nextInt();
            adj[u].add(v);
        }

        boolean found = dfs(s);
        if (found) {
            Stack<Integer> path = new Stack<>();
            int cur = t;
            while (cur != s) {
                path.push(cur);
                cur = parent[cur];
            }
            path.push(s);

            while (!path.isEmpty()) {
                System.out.print(path.pop() + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    static boolean dfs(int u) {
        visited[u] = true;
        if (u == t) {
            return true;
        }

        for (int v : adj[u]) {
            if (!visited[v]) {
                parent[v] = u;
                if (dfs(v)) {
                    return true;
                }
            }
        }

        return false;
    }
}
