import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[][] dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = arr[i][j];
			}
		}

		for (int i = 1; i < N; i++) {
			// i번째 집을
			// 빨강으로 칠할 때
			dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]);

			// 초록으로 칠할 때
			dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]);

			// 파랑으로 칠할 때
			dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
		int ans = Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2]));
		System.out.println(ans);
	}
}
