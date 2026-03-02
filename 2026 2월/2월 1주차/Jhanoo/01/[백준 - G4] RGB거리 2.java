import java.io.*;
import java.util.*;

public class Main {

    static final int R = 0;
    static final int G = 1;
    static final int B = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][3];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][R] = Integer.parseInt(st.nextToken());
            cost[i][G] = Integer.parseInt(st.nextToken());
            cost[i][B] = Integer.parseInt(st.nextToken());
        }

        int INF = 1_000_000_000;
        int min;
        int ans = INF;

        for (int C = 0; C < 3; C++) {

            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i], INF);
            }

            dp[0][C] = cost[0][C];
            for (int i = 1; i < N; i++) {
                dp[i][R] = Math.min(dp[i - 1][G], dp[i - 1][B]) + cost[i][R];
                dp[i][G] = Math.min(dp[i - 1][R], dp[i - 1][B]) + cost[i][G];
                dp[i][B] = Math.min(dp[i - 1][R], dp[i - 1][G]) + cost[i][B];
            }
            // 첫 집이 R이면 마지막 집은 G,B 비교, G면 R,B, B면 R,G
            min = Math.min(dp[N - 1][C == R ? G : R], dp[N - 1][C == B ? G : B]);
            ans = Math.min(ans, min);
        }

        System.out.println(ans);
    }
}