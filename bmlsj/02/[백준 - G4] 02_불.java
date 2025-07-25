import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int w, h;
	static String[][] map;
	static int[][] visited;
	static int ans = -1;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			String[] split = br.readLine().split(" ");
			h = Integer.parseInt(split[0]);
			w = Integer.parseInt(split[1]);

			map = new String[w][h];
			visited = new int[w][h];

			int sx = -1, sy = -1;
			ans = -1;
			for (int i = 0; i < w; i++) {
				split = br.readLine().split("");
				for (int j = 0; j < h; j++) {
					map[i][j] = split[j];
					if (map[i][j].equals("@")) { // 시작 지점
						sx = i;
						sy = j;
					}
				}
			}

			move(sx, sy);
			System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);
		}

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void move(int x, int y) {

		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] { x, y });

		Queue<int[]> fireQueue = new ArrayDeque<int[]>();

		int[][] fireVisited = new int[w][h];
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				fireVisited[i][j] = -1; // 불이 퍼지지 않은 상태로 초기화
			}
		}

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				if (map[i][j].equals("*")) {
					fireQueue.offer(new int[] { i, j });
					fireVisited[i][j] = 0;
				}
			}
		}

		while (!fireQueue.isEmpty()) {
			int[] curr = fireQueue.poll();
			int fx = curr[0], fy = curr[1];

			for (int i = 0; i < 4; i++) {
				int nx = fx + dx[i];
				int ny = fy + dy[i];

				if (nx < 0 || ny < 0 || ny >= h || nx >= w) {
					continue;
				}

				if (fireVisited[nx][ny] == -1 && map[nx][ny].equals(".")) {
					fireVisited[nx][ny] = fireVisited[fx][fy] + 1;
					fireQueue.offer(new int[] { nx, ny });
				}
			}
		}
		
		if (x == 0 || x == w - 1 || y == 0 || y == h - 1) {
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

				if (nx < 0 || ny < 0 || ny >= h || nx >= w) {
					ans = visited[x][y] + 1;
					return;
				}

				if (visited[nx][ny] == 0 && map[nx][ny].equals(".") && 
						(fireVisited[nx][ny] == -1
						|| fireVisited[nx][ny] > visited[x][y] + 1)) {
					visited[nx][ny] = visited[x][y] + 1;
					queue.offer(new int[] { nx, ny });
				}
			}
		}

	}
}
