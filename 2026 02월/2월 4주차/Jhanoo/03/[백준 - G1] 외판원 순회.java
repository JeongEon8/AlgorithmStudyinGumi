import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] W = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int start = 0;
        int FULL = (1 << N) - 1;
        final int INF = 1_000_000_000;

        int[][] dp = new int[1 << N][N]; // dp[방문한 도시 bitmask][현재 도시]
        for (int mask = 0; mask <= FULL; mask++) {
            Arrays.fill(dp[mask], INF);
        }

        dp[1 << start][start] = 0;

        for (int mask = 1; mask <= FULL; mask++) {
            if ((mask & (1 << start)) == 0) continue;

            for (int u = 0; u < N; u++) {
                if ((mask & (1 << u)) == 0) continue;

                int cur = dp[mask][u];
                if (cur == INF) continue;

                for (int v = 0; v < N; v++) {
                    if ((mask & (1 << v)) != 0) continue; // 이미 방문한 경우 스킵

                    if (W[u][v] == 0) continue; // 길 없음
                    int nmask = mask | (1 << v); // v 방문
                    dp[nmask][v] = Math.min(dp[nmask][v], dp[mask][u] + W[u][v]);
                }
            }
        }

        int ans = INF;
        for (int u = 1; u < N; u++) {
            if (dp[FULL][u] == INF) continue;
            if (W[u][start] == 0) continue;
            ans = Math.min(ans, dp[FULL][u] + W[u][start]);
        }

        System.out.println(ans);
    }
}