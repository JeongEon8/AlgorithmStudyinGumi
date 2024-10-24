import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int mod = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] dp = new int[n + 1];
		if (n > 0) {
			dp[1] = 1;
			for (int i = 2; i <= n; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
			}
		}
		System.out.println(dp[n]);

	}

}