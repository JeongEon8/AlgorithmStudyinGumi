import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int r, c, d;

	static int[] dx = { -1, 0, 1, 0 }; // 좌, 하, 우, 상
	static int[] dy = { 0, 1, 0, -1 };

	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		clean(r, c, d);
		System.out.println(result);
	}

	private static void clean(int x, int y, int dir) {
		if (!visited[x][y]) {
			visited[x][y] = true;
			result++;
		}

		for (int i = 0; i < 4; i++) {
			dir = (dir + 3) % 4;
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0 && !visited[nx][ny]) {
				clean(nx, ny, dir);
				return;
			}
		}

		int backDir = (dir + 2) % 4;
		int bx = x + dx[backDir];
		int by = y + dy[backDir];

		if (bx >= 0 && bx < N && by >= 0 && by < M && map[bx][by] == 0) {
			clean(bx, by, dir);
		}
	}
}