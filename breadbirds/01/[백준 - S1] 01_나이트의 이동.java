import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int dx[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int dy[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int l, nowX, nowY, toX, toY;
	static int arr[][];
	static boolean visited[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			l = Integer.parseInt(br.readLine());
			arr = new int[l][l];
			visited = new boolean[l][l];

			StringTokenizer st = new StringTokenizer(br.readLine());
			nowX = Integer.parseInt(st.nextToken());
			nowY = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			toX = Integer.parseInt(st.nextToken());
			toY = Integer.parseInt(st.nextToken());

			if(!visited[nowY][nowX]) {
			System.out.println(bfs(nowY, nowX));
			}

		}
	}

	private static int bfs(int y, int x) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { y, x, 0 });
		visited[y][x] = true;

		while (!queue.isEmpty()) {
			int current[] = queue.poll();

			for (int i = 0; i < 8; i++) {
				int ny = current[0] + dy[i];
				int nx = current[1] + dx[i];
				int cnt = current[2];

				if (nx < 0 || ny < 0 || nx >= l || ny >= l || visited[ny][nx]) {
					continue;
				}

				if (ny == toY && nx == toX) {
					return cnt + 1;
				}

				if (!visited[ny][nx]) {
					queue.add(new int[] { ny, nx, cnt + 1 });
					visited[ny][nx] = true;
				}
			}

		}
		return 0;
	}

}