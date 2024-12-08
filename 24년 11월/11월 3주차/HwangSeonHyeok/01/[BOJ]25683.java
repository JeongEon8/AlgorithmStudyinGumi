import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		long[][] m = new long[n][2];
		for (int i = 0; i < n; i++) {
			String[] split = in.readLine().split(" ");
			m[i][0] = Integer.parseInt(split[0]);
			m[i][1] = Integer.parseInt(split[1]);
		}
		long[] dp = new long[n];
		dp[0] = 0;
		dp[1] = m[0][0] * m[0][1] * m[1][1];
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 1] + m[0][0] * m[i][0] * m[i][1];

		}

		long[] dp2 = new long[n];
		dp2[0] = 0;
		dp2[1] = m[n - 1][0] * m[n - 1][1] * m[n - 2][0];
		for (int i = 2; i < n; i++) {
			dp2[i] = dp2[i - 1] + m[n - i - 1][0] * m[n - i - 1][1] * m[n - 1][1];

		}
		long ans = Long.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			ans = Math.min(ans, dp[i] + dp2[n - i - 1]);
		}

		System.out.println(ans);

	}

}