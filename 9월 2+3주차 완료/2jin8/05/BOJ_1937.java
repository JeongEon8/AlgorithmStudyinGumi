import java.util.*;
import java.io.*;

public class BOJ_1937 {

	static int N;
	static int[][] map, dp;
	static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		map = new int[N][N];
		dp = new int[N][N];
		PriorityQueue<Point> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dfs(i, j);
				ans = Math.max(ans, dp[i][j]);
			}
		}
		System.out.println(ans);
	}

	static int dfs(int x, int y) {
		// 방문하지 않은 경우 (방문했다면 자신의 dp 값을 return)
		if (dp[x][y] != 0)
			return dp[x][y];

		dp[x][y] = 1; // 자기 자신도 이동할 수 있는 칸에 포함
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;

			if (map[x][y] < map[nx][ny]) {
				// 현재 칸에서 이동할 수 있는 횟수가 더 큰 것으로 갱신
				dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
			}
		}
		return dp[x][y];
	}

	static class Point {
		int x, y, bamboo;

		public Point(int x, int y, int bamboo) {
			this.x = x;
			this.y = y;
			this.bamboo = bamboo;
		}
	}
}
