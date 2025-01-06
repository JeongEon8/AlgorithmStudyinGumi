import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		int size = input.length - 1;
		if (size == 0) {
			System.out.println(0);
		} else {
			int[][][] dp = new int[size + 1][5][5];
			dp[0][0][0] = 1;
			for (int i = 1; i <= size; i++) {
				int next = Integer.parseInt(input[i - 1]);
				for (int j = 0; j < 5; j++) {
					for (int k = 0; k < 5; k++) {
						if (dp[i - 1][k][j] != 0) {
							int nextPow = 0;
							if (k == 0)
								nextPow = 2;
							else if (k == next)
								nextPow = 1;
							else if (k == (next + 2) % 4)
								nextPow = 4;
							else if (k == 4 && next == 2)
								nextPow = 4;
							else
								nextPow = 3;
							dp[i][next][j] = dp[i][next][j] == 0 ? dp[i - 1][k][j] + nextPow
									: Math.min(dp[i][next][j], dp[i - 1][k][j] + nextPow);
						}
					}
					for (int k = 0; k < 5; k++) {
						if (dp[i - 1][j][k] != 0) {
							int nextPow = 0;
							if (k == 0)
								nextPow = 2;
							else if (k == next)
								nextPow = 1;
							else if (k == (next + 2) % 4)
								nextPow = 4;
							else if (k == 4 && next == 2)
								nextPow = 4;
							else
								nextPow = 3;
							dp[i][j][next] = dp[i][j][next] == 0 ? dp[i - 1][j][k] + nextPow
									: Math.min(dp[i][j][next], dp[i - 1][j][k] + nextPow);
						}
					}

				}
			}
			int last = Integer.parseInt(input[size - 1]);
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < 5; i++) {
				int a = dp[size][i][last] == 0 ? Integer.MAX_VALUE : dp[size][i][last];
				int b = dp[size][last][i] == 0 ? Integer.MAX_VALUE : dp[size][last][i];
				ans = Math.min(ans, Math.min(a, b));
			}
			System.out.println(ans - 1);
		}

	}

}