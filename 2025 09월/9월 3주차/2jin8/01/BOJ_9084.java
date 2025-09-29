import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9084 {

    static int N, M;
    static int[] coins, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            coins = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            M = Integer.parseInt(br.readLine());
            dp = new int[M + 1];
            dp[0] = 1;
            for (int coin : coins) {
                // 각 코인으로 만들 수 있는 경우를 더하기
                for (int i = 1; i <= M; i++) {
                    if (i < coin) continue;

                    dp[i] += dp[i - coin];
                }
            }
            sb.append(dp[M]).append("\n");
        }
        System.out.println(sb);
    }
}
