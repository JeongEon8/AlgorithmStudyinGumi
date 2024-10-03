import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7569 {

	static int[] dx = { 1, 0, -1, 0, 0, 0 };
	static int[] dy = { 0, 1, 0, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static int[][][] map;
	static Queue<Point> queue = new LinkedList<>();
	static int h, n, m;

	static class Point {
		int height;
		int row;
		int col;

		public Point(int height, int row, int col) {
			this.height = height;
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		m = sc.nextInt();
		n = sc.nextInt();
		h = sc.nextInt();
		map = new int[h ][n ][m ];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					map[i][j][k] = sc.nextInt();

					if (map[i][j][k] == 1) {
						queue.add(new Point(i, j, k)); // 시작점 추가
					}
				}
			}
		}

		System.out.println(bfs());

	}

	private static int bfs() {
		// TODO Auto-generated method stub

		while (!queue.isEmpty()) {
			Point point = queue.poll();
			int height = point.height;
			int row = point.row;
			int col = point.col;

			for (int i = 0; i < 6; i++) {
				int nh = height + dz[i];
				int nr = row + dy[i];
				int nc = col + dx[i];

				if (nh >= 0 && nr >= 0 && nc >= 0 && nh < h && nr < n && nc < m) {
					if (map[nh][nr][nc] == 0) {
						queue.add(new Point(nh, nr, nc));
						map[nh][nr][nc] = map[height][row][col] + 1;
					}
				}
			}

		}
		

		int result = 0;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[i][j][k] == 0) return -1;
					result = Math.max(result, map[i][j][k]);

				}
			}
		}
//		
//		if (result == 1) return 0;
//		else
			return result -1;

	}

}
