import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	private static int[][] map;
	private static int[][] visited;
	private static int n, m;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		n = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]);

		map = new int[n][m];
		visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			split = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		visited[0][0] = 1;
		find(0, 0);

		System.out.println(visited[n - 1][m - 1]);

	}

	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	public static void find(int x, int y) {

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });

		while (!q.isEmpty()) {

			int[] v = q.poll();
			x = v[0];
			y = v[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}

				if (map[nx][ny] == 1 && visited[nx][ny] == 0) {
					visited[nx][ny] = visited[x][y] + 1;
					q.add(new int[] { nx, ny });
				}
			}
		}

	}

}