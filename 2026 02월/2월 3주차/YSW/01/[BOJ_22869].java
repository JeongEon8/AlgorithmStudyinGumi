import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22869 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] stones = new int[n + 1];
		boolean[] dp = new boolean[n + 1];
		dp[1] = true;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			stones[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < n; i++) {
			if (!dp[i]) {
				continue;
			}
			for (int j = i + 1; j <= n; j++) {
				if (dp[j])
					continue;

				int power = (j - i) * (1 + Math.abs(stones[i] - stones[j]));

				if (power <= k) {
					dp[j] = true;
				}
			}
		}

		System.out.println(dp[n] ? "YES" : "NO");
	}
}