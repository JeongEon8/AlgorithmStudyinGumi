import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        int max = 10000;
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            split = in.readLine().split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            graph[from][to] = 1;

        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i != j && graph[i][j] == 0) {
                    graph[i][j] = max;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int from = 1; from <= n; from++) {
                for (int to = 1; to <= n; to++) {
                    graph[from][to] = Math.min(graph[from][to], graph[from][i] + graph[i][to]);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == max && graph[j][i] == max) {
                    flag = false;

                }
            }
            if (flag)
                ans++;
        }
        System.out.print(ans);
    }

}