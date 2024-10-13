import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static final int mod = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				dp[i][j] = Integer.parseInt(split[j]);
			}
		}
		n -= 2;
		for (; n >= 0; n--) {
			for (int i = 0; i < m; i++) {
				if (dp[n][i] == 1) {
					dp[n][i] = dp[n + 1][i];
					if (i > 0) {
						dp[n][i] += dp[n + 1][i - 1];
						dp[n][i] %= mod;
					}
					if (i < m - 1) {
						dp[n][i] += dp[n + 1][i + 1];
						dp[n][i] %= mod;
					}
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < m; i++) {
			if (dp[0][i] != 0) {
				ans = (ans + dp[0][i]) % mod;
			}
		}
		System.out.println(ans);

	}
}