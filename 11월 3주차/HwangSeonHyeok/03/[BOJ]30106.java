import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static class Area {
		int y, x;

		public Area(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int n, m, k;
	static int[][] room;
	static boolean[][] visited;

	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	static boolean checkRange(int nextY, int nextX) {
		return nextY >= 0 && nextY < n && nextX >= 0 && nextX < m;
	}

	static void bfs(int y, int x) {
		Queue<Area> q = new ArrayDeque<>();
		visited[y][x] = true;
		q.add(new Area(y, x));
		while (!q.isEmpty()) {
			Area current = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = current.y + dy[i];
				int nextX = current.x + dx[i];
				if (checkRange(nextY, nextX) && !visited[nextY][nextX]
						&& Math.abs(room[current.y][current.x] - room[nextY][nextX]) <= k) {
					visited[nextY][nextX] = true;
					q.add(new Area(nextY, nextX));
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");

		n = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]);
		k = Integer.parseInt(split[2]);

		room = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				room[i][j] = Integer.parseInt(split[j]);
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					ans++;
					bfs(i, j);
				}
			}
		}
		System.out.println(ans);

	}

}