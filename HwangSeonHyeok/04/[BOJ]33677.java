import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[][] dp = new int[n + 1][2];
		if (n > 0) {
			dp[1][0] = 1;
			dp[1][1] = 1;
			for (int i = 2; i <= n; i++) {
				int minDay = dp[i - 1][0] + 1;
				int minWater = dp[i - 1][1] + 1;
				if (i % 3 == 0 && minDay >= dp[i / 3][0] + 1) {
					if (minDay == dp[i / 3][0] + 1) {
						minWater = Math.min(minWater, dp[i / 3][1] + 3);
					} else {
						minDay = dp[i / 3][0] + 1;
						minWater = dp[i / 3][1] + 3;
					}
				}
				int sqrt = (int) Math.sqrt(i);
				if (sqrt * sqrt == i && minDay >= dp[sqrt][0] + 1) {
					if (minDay == dp[sqrt][0] + 1) {
						minWater = Math.min(minWater, dp[sqrt][1] + 5);
					} else {
						minDay = dp[sqrt][0] + 1;
						minWater = dp[sqrt][1] + 5;
					}
				}
				dp[i][0] = minDay;
				dp[i][1] = minWater;
			}
		}
		System.out.println(dp[n][0] + " " + dp[n][1]);

	}

}