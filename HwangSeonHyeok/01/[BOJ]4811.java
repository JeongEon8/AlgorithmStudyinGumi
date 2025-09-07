import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long[][] dp = new long[31][31];
		for (int i = 0; i <= 30; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i <= 30; i++) {
			for (int j = 0; j <= 30; j++) {
				dp[i][j] = 0;
				if (j > 0)
					dp[i][j] += dp[i][j - 1];
				if (j + 1 <= 30)
					dp[i][j] += dp[i - 1][j + 1];
			}
		}
		while (true) {
			int n = Integer.parseInt(in.readLine());
			if (n == 0)
				break;
			sb.append(dp[n][0]).append("\n");
		}
		System.out.println(sb);

	}

}