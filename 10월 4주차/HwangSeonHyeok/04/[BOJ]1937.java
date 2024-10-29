import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	static int n;
	static int[][] bamboos;
	static int[][] memo;

	static boolean checkRange(int y, int x) {
		return y >= 0 && x >= 0 && y < n && x < n;
	}

	static int dfs(int y, int x) {
		if (memo[y][x] == -1) {
			int max = 0;
			for (int i = 0; i < 4; i++) {
				int nextY = y + dy[i];
				int nextX = x + dx[i];
				if (checkRange(nextY, nextX) && bamboos[nextY][nextX] > bamboos[y][x]) {
					max = Math.max(max, dfs(nextY, nextX));
				}
			}
			memo[y][x] = max + 1;
		}
		return memo[y][x];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		bamboos = new int[n][n];
		memo = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] split = in.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				bamboos[i][j] = Integer.parseInt(split[j]);
				memo[i][j] = -1;
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans = Math.max(ans, dfs(i, j));
			}
		}
		System.out.println(ans);

	}

}