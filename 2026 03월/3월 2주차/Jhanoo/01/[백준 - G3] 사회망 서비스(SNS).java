import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        dp = new int[N + 1][2];
        visited = new boolean[N + 1];

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int u) {
        visited[u] = true;
        dp[u][0] = 0;
        dp[u][1] = 1;

        for (int v : graph[u]) {
            if (visited[v]) continue;

            dfs(v);
            dp[u][0] += dp[v][1];
            dp[u][1] += Math.min(dp[v][0], dp[v][1]);
        }
    }
}