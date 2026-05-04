import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static int garo, sero;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static boolean visited[][];
	static int max = 0;
	static int result2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());

		arr = new int[sero][garo];
		visited = new boolean[sero][garo];

		for (int i = 0; i < sero; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < garo; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		for (int i = 0; i < sero; i++) {
			for (int j = 0; j < garo; j++) {
				if (!visited[i][j] && arr[i][j] == 1) {

					int result = bfs(i, j);

					result2++;

					if (result > max) {
						max = result;
					}
				}
			}
		}
		System.out.println(result2);
		System.out.println(max);

	}

	private static int bfs(int y, int x) {
		int cnt = 1;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { y, x });
		visited[y][x] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current[1] + dx[i];
				int ny = current[0] + dy[i];

				if (nx < 0 || ny < 0 || nx >= garo || ny >= sero) {
					continue;
				}
				if (!visited[ny][nx] && arr[ny][nx] == 1) {
					queue.add(new int[] { ny, nx });
					visited[ny][nx] = true;
					cnt++;
				}

			}
		}
		return cnt;
	}
}