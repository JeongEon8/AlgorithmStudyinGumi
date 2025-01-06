import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int n = Integer.parseInt(in.readLine());
			if (n == 0)
				break;
			long[] dp = new long[n + 1];
			for (int i = 1; i <= n; i++) {
				dp[i] = Long.parseLong(in.readLine());
			}
			Long ans = -100000L;
			for (int i = 1; i <= n; i++) {
				dp[i] = Math.max(dp[i - 1], 0) + dp[i];
				if (ans < dp[i]) {
					ans = dp[i];
				}
			}
			System.out.println(ans);
		}
	}

}