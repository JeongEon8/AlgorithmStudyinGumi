import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9251 {

    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] char1 = br.readLine().toCharArray();
        char[] char2 = br.readLine().toCharArray();

        N = char1.length;
        M = char2.length;
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (char1[i - 1] == char2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}
