import java.util.Scanner;

public class BOJ_14503 {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] map;
	static int n, m, dir;
	static int count = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		dir = sc.nextInt(); // 서남동북 ..
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		clean(x, y, dir);

		System.out.println(count);

	}

	private static void clean(int x, int y, int dir) {

		map[x][y] = -1; // 현재 칸을 청소함

		for (int i = 0; i < 4; i++) {
			dir = (dir + 3) % 4; 

			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (map[nx][ny] == 0) {
					count++;
					clean(nx, ny, dir);
					return;
				}
			}

		}

		int d = (dir + 2) % 4; // 반대방향으로
		int bx = x + dx[d];
		int by = y + dy[d];

		if (bx >= 0 && by >= 0 && bx < n && by < m) {
			if (map[bx][by] != 1) {
				clean(bx, by, dir);
			}
		}

	}

}
