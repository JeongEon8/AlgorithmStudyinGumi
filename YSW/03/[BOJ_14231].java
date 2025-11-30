import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_14231 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] boxsSize = new int[n + 1];
		String[] inputs = br.readLine().split(" ");
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			boxsSize[i] = Integer.parseInt(inputs[i - 1]);
		}

		int result = 0;
		for (int i = 1; i <= n; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (boxsSize[j] < boxsSize[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			result = Math.max(result, dp[i]);
		}

		System.out.println(result);
	}
}