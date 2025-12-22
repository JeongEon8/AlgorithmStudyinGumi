import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int y, x, step;

		public Point(int y, int x, int step) {
			super();
			this.y = y;
			this.x = x;
			this.step = step;
		}

	}

	static int r, c, n;

	static int[][] graph;
	static int[] dx, dy;

	static boolean isInRange(int y, int x) {
		return x >= 0 && y >= 0 && y < r && x < c;
	}

	static int solve() {
		boolean[][] visited = new boolean[r][c];
		Queue<Point> que = new ArrayDeque<>();
		for (int i = 0; i < c; i++) {
			if (graph[0][i] == 1) {
				que.add(new Point(0, i, 0));
				visited[0][i] = true;
			}
		}
		while (!que.isEmpty()) {
			Point current = que.poll();
			if (current.y == r - 1) {
				return current.step;

			}
			for (int i = 0; i < n; i++) {
				int nextY = current.y + dy[i];
				int nextX = current.x + dx[i];
				if (isInRange(nextY, nextX) && !visited[nextY][nextX] && graph[nextY][nextX] == 1) {
					que.add(new Point(nextY, nextX, current.step + 1));
					visited[nextY][nextX] = true;
				}

			}
		}

		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		graph = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < c; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		n = Integer.parseInt(in.readLine());
		dx = new int[n];
		dy = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			dy[i] = Integer.parseInt(st.nextToken());
			dx[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solve());

	}

}