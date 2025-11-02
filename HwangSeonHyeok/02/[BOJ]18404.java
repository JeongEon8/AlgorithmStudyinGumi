import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int[] dy = { -1, 1, -2, 2, -2, 2, -1, 1 };
	static int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int n, m;

	static boolean inRange(int y, int x) {
		return y > 0 && x > 0 && y <= n && x <= n;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] board = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(board[i], -1);
		}
		st = new StringTokenizer(in.readLine());
		int startY = Integer.parseInt(st.nextToken());
		int startX = Integer.parseInt(st.nextToken());
		Point[] enemies = new Point[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int enemyY = Integer.parseInt(st.nextToken());
			int enemyX = Integer.parseInt(st.nextToken());
			enemies[i] = new Point(enemyY, enemyX);
		}
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(startY, startX));
		board[startY][startX] = 0;
		while (!q.isEmpty()) {
			Point current = q.poll();
			for (int i = 0; i < 8; i++) {
				int nextY = current.y + dy[i];
				int nextX = current.x + dx[i];
				if (inRange(nextY, nextX) && board[nextY][nextX] == -1) {
					board[nextY][nextX] = board[current.y][current.x] + 1;
					q.add(new Point(nextY, nextX));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Point enemy : enemies) {
			int y = enemy.y;
			int x = enemy.x;
			sb.append(board[y][x]).append(" ");
		}
		System.out.println(sb);

	}

}