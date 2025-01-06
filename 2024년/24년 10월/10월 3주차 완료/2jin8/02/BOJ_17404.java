import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17404 {

	static int N, INF = 1_000_000_000;
	static int[][] cost;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int minCost = INF;
		for (int i = 0; i < 3; i++) { // 1번 집에 칠할 색 정하기 (R, G, B)
			dp = copyArr();
			dp[0][i] = cost[0][i];
			dp[0][(i + 1) % 3] = INF; // 나머지 집은 선택 불가
			dp[0][(i + 2) % 3] = INF;
			dp[N - 1][i] = INF; // N번째 집은 같은 색으로 칠하기 불가

			// 2번 ~ N번째 집 칠하기
			for (int j = 1; j < N; j++) {
				// R
				dp[j][0] += Math.min(dp[j - 1][1], dp[j - 1][2]);

				// G
				dp[j][1] += Math.min(dp[j - 1][0], dp[j - 1][2]);

				// B
				dp[j][2] += Math.min(dp[j - 1][0], dp[j - 1][1]);
			}

			for (int j = 0; j < 3; j++) {
				minCost = Math.min(minCost, dp[N - 1][j]);
			}
		}
		System.out.println(minCost);
	}

	static int[][] copyArr() {
		int[][] dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			dp[i] = cost[i].clone();
		}
		return dp;
	}
}
