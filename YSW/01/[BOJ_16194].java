import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_16194 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			dp[i] = Integer.parseInt(inputs[i - 1]);
			for (int j = 1; j < i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
			}
		}

		System.out.println(dp[N]);
	}

}
