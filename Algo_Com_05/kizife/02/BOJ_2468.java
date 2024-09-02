import java.util.Scanner;

public class Main {

	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int n;
	static int maxHeight;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n][n];
//		visit = new boolean[n][n];
		maxHeight = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				maxHeight = Math.max(maxHeight, map[i][j]); // 입력값 중 최대높이 (반복문 돌리려고)
			}
		}

		int maxCount = 0; // 안전지대 최대 개수 초기화

		for (int h = 0; h <= maxHeight; h++) {
			int count = 0; // 안전지대 개수
			visit = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visit[i][j] && map[i][j] > h) {
						count++; // 안전지대 개수 세기
						dfs(i, j, h);
					}
				}
			}
			maxCount = Math.max(count, maxCount);
		}

		System.out.println(maxCount);

	}

	private static void dfs(int x, int y, int height) {
		// TODO Auto-generated method stub
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] > height && !visit[nx][ny]) {
				
					dfs(nx, ny, height);
				
			}

		}

	}
}
