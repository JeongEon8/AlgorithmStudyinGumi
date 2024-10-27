import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		long[][] dp = new long[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			split = in.readLine().split(" ");
			for (int j = 1; j <= m; j++) {
				dp[i][j] = Long.parseLong(split[j - 1]);
			}
		}
		for (int i = 2; i <= n; i++) {
			dp[i][0] = (int) 1e9;
		}
		for (int i = 2; i <= m; i++) {
			dp[0][i] = (int) 1e9;
		}
		int stealth = Integer.parseInt(in.readLine());
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		if (stealth < dp[n][m]) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			System.out.println(dp[n][m]);
		}

	}

}