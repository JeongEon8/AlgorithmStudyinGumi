import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int maxpow = (int) Math.floor(Math.sqrt(n));
		int[] dp = new int[n + 1];
		int[] pow = new int[maxpow + 1];
		for (int i = 1; i <= maxpow; i++) {
			pow[i] = i * i;
		}
		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 1; j <= Math.floor(Math.sqrt(i)); j++) {
				dp[i] = Math.min(dp[i - pow[j]] + 1, dp[i]);
			}
		}

		System.out.println(dp[n]);

	}

}