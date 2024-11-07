import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7562 {

	static int[][] map;
	static boolean[][] visit;
	static int n;
	static int nowX, nowY, goX, goY;
	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			n = sc.nextInt();
			map = new int[n][n];
			visit = new boolean[n][n];

			nowX = sc.nextInt();
			nowY = sc.nextInt();
			goX = sc.nextInt();
			goY = sc.nextInt();

			bfs();

			System.out.println(map[goX][goY]);
		}
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { nowX, nowY });
		visit[nowX][nowY] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if (!visit[nx][ny]) {
						queue.add(new int[] { nx, ny });
						map[nx][ny] = map[x][y] + 1;
						visit[nx][ny] = true;
					}
				}
			}
		}

	}

}
