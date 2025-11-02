import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] scores = new int[n];
		for (int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		long[][] dp = new long[n][4];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -Long.MAX_VALUE);
		}
		dp[0][0] = scores[0] * 2;
		dp[0][3] = scores[0];
		for (int i = 1; i < n; i++) {
			int score = scores[i];
			dp[i][0] = Math.max(dp[i - 1][2], dp[i - 1][3]) + score * 2;
			dp[i][1] = dp[i - 1][0] + score * 2;
			if (i > 1) {
				dp[i][2] = dp[i - 1][1] + score * 2;
			}

			dp[i][3] = Math.max(dp[i - 1][2], dp[i - 1][3]) + score;

		}
		long ans = -Long.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			ans = Math.max(dp[n - 1][i], ans);
		}
		System.out.println(ans);
	}

}