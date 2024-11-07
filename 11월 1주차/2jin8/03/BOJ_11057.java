import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11057 {

	static int N, M = 10, DIV = 10_007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int[][] dp = new int[N + 1][M + 1];
		Arrays.fill(dp[1], 1); // N이 1일 때는 모두 1
		dp[1][M] = 10;

		for (int i = 2; i <= N; i++) {
			dp[i][0] = dp[i - 1][M];
			int total = dp[i][0];
			for (int j = 1; j < M; j++) {
				dp[i][j] = dp[i][j - 1] - dp[i - 1][j - 1];
				if (dp[i][j] < 0)
					dp[i][j] += DIV;

				total = (total + dp[i][j]) % DIV;
			}
			dp[i][M] = total;
		}
		System.out.println(dp[N][M] % DIV);
	}
}
