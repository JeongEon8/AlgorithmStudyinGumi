import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cost = new int[N];
        int[] gain = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            gain[i] = Integer.parseInt(st.nextToken());
        }

        int limit = C + 100;
        int[] dp = new int[limit + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = gain[i]; j <= limit; j++) {
                dp[j] = Math.min(dp[j], dp[j - gain[i]] + cost[i]);
            }
        }

        int ans = INF;
        for (int i = C; i <= limit; i++) {
            ans = Math.min(ans, dp[i]);
        }

        System.out.println(ans);
    }
}