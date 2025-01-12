import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static boolean[][] graph;
	static int m;
	static int[] dx = { 1, 0, 0 };
	static int[] dy = { 0, 1, -1 };

	static class Point {
		int y, x, step;

		public Point(int y, int x, int step) {
			this.y = y;
			this.x = x;
			this.step = step;
		}

	}

	static int bfs(int x, int y) {
		Queue<Point> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[2][m];
		q.add(new Point(y, x, 1));
		visited[y][x] = true;
		while (!q.isEmpty()) {
			Point current = q.poll();
			if (current.x == m - 1) {
				return current.step;
			}
			for (int i = 0; i < 3; i++) {
				int nextY = current.y + dy[i];
				int nextX = current.x + dx[i];
				if (nextY >= 0 && nextY < 2 && !visited[nextY][nextX] && graph[nextY][nextX]) {
					visited[nextY][nextX] = true;
					q.add(new Point(nextY, nextX, current.step + 1));
				}
			}
		}
		return -1;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		m = Integer.parseInt(in.readLine());
		int cnt = 0;
		graph = new boolean[2][m];
		for (int i = 0; i < 2; i++) {
			String str = in.readLine();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == '.') {
					graph[i][j] = true;
					cnt++;
				}
			}
		}
		int ans = 101;
		ans = graph[0][0] ? Math.min(ans, bfs(0, 0)) : ans;
		ans = graph[1][0] ? Math.min(ans, bfs(0, 1)) : ans;

		System.out.println(cnt - ans);

	}

}