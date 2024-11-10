import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		long[][] dp = new long[11][2001];
		for (int i = 1; i <= 2000; i++) {
			dp[1][i] = i;

		}
		for (int i = 2; i <= 10; i++) {
			for (int j = (int) Math.pow(2, i - 1); j <= 2000; j++) {
				dp[i][j] += dp[i - 1][j / 2] + dp[i][j - 1];

			}
		}

		for (int i = 0; i < t; i++) {
			String[] split = in.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);

			System.out.println(dp[n][m]);

		}

	}

}