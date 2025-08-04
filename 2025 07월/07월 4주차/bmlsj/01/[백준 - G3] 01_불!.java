import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int R, C;
	static String[][] map;
	static int[][] visited;
	static int ans = -1;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		R = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);

		map = new String[R][C];
		visited = new int[R][C];

		int sx = -1, sy = -1;
		for (int i = 0; i < R; i++) {
			split = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = split[j];
				if (map[i][j].equals("J")) {
					sx = i;
					sy = j;
				}
			}
		}

		escape(sx, sy);
		System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void escape(int x, int y) {

		int[][] fireTime = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				fireTime[i][j] = -1; // 불이 퍼지지 않은 상태로 초기화
			}
		}

		Queue<int[]> queue = new ArrayDeque<int[]>();
		Queue<int[]> fireQueue = new ArrayDeque<>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j].equals("F")) {
					fireQueue.offer(new int[] { i, j });
					fireTime[i][j] = 0;
				}
			}
		}

		while (!fireQueue.isEmpty()) {
			int[] curr = fireQueue.poll();
			int fx = curr[0];
			int fy = curr[1];

			for (int i = 0; i < 4; i++) {
				int nx = fx + dx[i];
				int ny = fy + dy[i];

				if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
					continue;
				}

				if (fireTime[nx][ny] == -1 && map[nx][ny].equals(".")) {
					fireTime[nx][ny] = fireTime[fx][fy] + 1;
					fireQueue.offer(new int[] { nx, ny });
				}
			}
		}

		queue.offer(new int[] { x, y });

		// 지훈이의 시작 위치가 이미 가장자리일 경우
		if (x == 0 || x == R - 1 || y == 0 || y == C - 1) {
			ans = 1;
			return;
		}

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			x = curr[0];
			y = curr[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
					ans = visited[x][y] + 1;
					return;
				}

				if (visited[nx][ny] == 0 && map[nx][ny].equals(".")
						&& (fireTime[nx][ny] == -1 || fireTime[nx][ny] > visited[x][y] + 1)) {

					visited[nx][ny] = visited[x][y] + 1;

					queue.offer(new int[] { nx, ny });
				}
			}

		}

	}

}
