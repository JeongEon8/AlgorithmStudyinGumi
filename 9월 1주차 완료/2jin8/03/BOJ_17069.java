import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17069 {

	static int N;
	static int[][] arr;
	static long[][][] dp; // int 범위를 벗어남..!

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		dp = new long[3][N + 1][N + 1];
		StringTokenizer st = null;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][1][2] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 3; j <= N; j++) {
				// 벽이면 아예 올 수 없음
				if (arr[i][j] == 1)
					continue;

				dp[0][i][j] = dp[0][i][j - 1] + dp[2][i][j - 1];
				dp[1][i][j] = dp[1][i - 1][j] + dp[2][i - 1][j];

				// 대각선 파이프가 놓여지는 위치에 벽이 없어야 함
				if (arr[i - 1][j] == 0 && arr[i][j - 1] == 0)
					dp[2][i][j] = dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[2][i - 1][j - 1];
			}
		}
		System.out.println(dp[0][N][N] + dp[1][N][N] + dp[2][N][N]);
	}
}
