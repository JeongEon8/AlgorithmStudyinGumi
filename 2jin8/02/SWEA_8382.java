import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_8382 {
	static int N = 100, M = 200; // 음수값을 양수값으로 변경시키기 위함
	static boolean[][][] visited;
	static int[] move = { 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 시작이 가로냐 세로냐?
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken()) + N;
			int sy = Integer.parseInt(st.nextToken()) + N;
			int ex = Integer.parseInt(st.nextToken()) + N;
			int ey = Integer.parseInt(st.nextToken()) + N;

			visited = new boolean[2][M + 1][M + 1]; // [0]: 가로로 시작, [1][][]: 세로로 시작
			sb.append("#").append(t).append(" ").append(bfs(sx, sy, ex, ey)).append("\n");
		}
		System.out.println(sb);
	}

	static int bfs(int sx, int sy, int ex, int ey) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(sx, sy, 0, 0, 0)); // 가로로 시작
		visited[0][sx][sy] = true;
		queue.offer(new Point(sx, sy, 1, 1, 0)); // 세로로 시작
		visited[1][sx][sy] = true;

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			int x = now.x, y = now.y;
			if (x == ex && y == ey) {
				return now.dist;
			}

			if (now.d == 0) { // 가로 이동이었으면 지금은 세로 이동
				for (int i = 0; i < 2; i++) {
					int ny = y + move[i];
					if (ny < 0 || ny > M)
						continue;

					if (!visited[now.start][x][ny]) {
						queue.offer(new Point(x, ny, now.start, 1, now.dist + 1));
						visited[now.start][x][ny] = true;
					}
				}
			} else { // 세로 이동이었으면 지금은 가로 이동
				for (int i = 0; i < 2; i++) {
					int nx = x + move[i];
					if (nx < 0 || nx > M)
						continue;

					if (!visited[now.start][nx][y]) {
						queue.offer(new Point(nx, y, now.start, 0, now.dist + 1));
						visited[now.start][nx][y] = true;
					}
				}
			}
		}
		return -1;
	}

	static class Point {
		int x, y, start, d, dist;

		public Point(int x, int y, int start, int d, int dist) {
			this.x = x;
			this.y = y;
			this.start = start;
			this.d = d;
			this.dist = dist;
		}
	}
}
