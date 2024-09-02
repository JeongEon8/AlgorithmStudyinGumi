import java.util.Scanner;

public class Solution {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int[][] map;
	static boolean[][] visit;
	static int N;
	static int maxDepth; // 최대 깊이
	static int result; // 방의 숫자

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			N = sc.nextInt();
			map = new int[N][N];
			visit = new boolean[N][N];
			maxDepth = 0;
			result = 0;

			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					map[j][j2] = sc.nextInt();
				}
			}

			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					dfs(map[j][j2], 1, j, j2);
				}
			}

			System.out.println("#" + i + " " + result + " " + maxDepth);

		}

	}

	private static void dfs(int startpoint, int depth, int x, int y) {
		// TODO Auto-generated method stub
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (map[nx][ny] == (map[x][y] + 1) && !visit[nx][ny])
					dfs(startpoint, depth + 1, nx, ny);
			}
		}

		if (depth > maxDepth) {
			maxDepth = depth;
			result = startpoint;
		}

		if (depth == maxDepth) {
			result = Math.min(startpoint, result);
		}
		
		visit[x][y] = false;
		
	}

}
