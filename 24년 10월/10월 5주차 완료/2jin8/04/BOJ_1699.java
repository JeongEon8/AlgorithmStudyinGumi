import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;

public class BOJ_1699 {
	static final int MAX = 100_001;
	static int[] dp = new int[MAX];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Arrays.fill(dp, MAX);
		dp[0] = 0; dp[1] = 1;
		dp[2] = 2; dp[3] = 3;
		for (int i = 4; i <= N; i++) {
			int sqrt = (int) Math.sqrt(i);
			for (int j = 1; j <= sqrt; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		System.out.println(dp[N]);
	}
}
