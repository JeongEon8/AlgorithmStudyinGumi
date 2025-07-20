import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10844 {

    static int N, M = 10;
    static int DIV = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][M];

        // N = 1
        for (int i = 0; i < M; i++) {
            dp[1][i] = 1;
        }

        // 2 ~ N
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i -1][1];
            for (int j = 1; j < M - 1; j++) {
                dp[i][j] = (dp[i - 1][j - 1] % DIV) + (dp[i - 1][j + 1] % DIV);
            }
            dp[i][9] = dp[i - 1][8];
        }

        long total = 0;
        for (int i = 1; i < M; i++) {
            total = (total + dp[N][i]) % DIV;
        }
        System.out.println(total);
    }
}
