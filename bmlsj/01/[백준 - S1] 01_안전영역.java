import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static int N;
	private static int[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		int max = -1;

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(split[j]);
				max = Math.max(max, Integer.parseInt(split[j]));
			}
		}

		int ans = 1;
		for (int height = 2; height <= max; height++) {
			visited = new boolean[N][N];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] >= height) {
						area(i, j, height);
						cnt++;
					}
				}
			}

			ans = Math.max(ans, cnt);
		}

		System.out.println(ans);

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static public void area(int x, int y, int height) {

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
				continue;
			}

			if (!visited[nx][ny] && map[nx][ny] >= height) {
				visited[nx][ny] = true;
				area(nx, ny, height);
			}
		}

	}

}