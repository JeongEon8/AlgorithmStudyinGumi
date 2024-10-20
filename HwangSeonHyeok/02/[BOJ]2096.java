import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[][] dp = new int[3][2];
		String[] split = in.readLine().split(" ");
		for (int i = 0; i < 3; i++) {
			dp[i][0] = Integer.parseInt(split[i]);
			dp[i][1] = Integer.parseInt(split[i]);
		}
		int[][] current = new int[3][2];
		for (int i = 1; i < n; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				current[j][0] = Integer.parseInt(split[j]);
				current[j][1] = Integer.parseInt(split[j]);
			}
			current[0][0] += Math.max(dp[0][0], dp[1][0]);
			current[0][1] += Math.min(dp[0][1], dp[1][1]);

			current[1][0] += Math.max(dp[0][0], Math.max(dp[1][0], dp[2][0]));
			current[1][1] += Math.min(dp[0][1], Math.min(dp[1][1], dp[2][1]));

			current[2][0] += Math.max(dp[1][0], dp[2][0]);
			current[2][1] += Math.min(dp[1][1], dp[2][1]);
			for (int j = 0; j < 3; j++) {
				dp[j][0] = current[j][0];
				dp[j][1] = current[j][1];
			}

		}
		System.out.print(Math.max(dp[0][0], Math.max(dp[1][0], dp[2][0])) + " ");
		System.out.print(Math.min(dp[0][1], Math.min(dp[1][1], dp[2][1])));

	}

}