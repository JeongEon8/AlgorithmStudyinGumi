import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w, h, answer;
	static int arr[][];
	static boolean visited[][];
	static int dx[] = { 0, 0, -1, 1, -1, 1, 1, -1 };
	static int dy[] = { -1, 1, 0, 0, -1, -1, 1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			arr = new int[h][w];
			visited = new boolean[h][w];
			answer = 0;

			if (w == 0 && h == 0) {
				break;
			}

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && arr[i][j] == 1) {

						answer += bfs(i, j);
					}
				}
			}
			System.out.println(answer);
		}

		// 섬의 개수
		// 1이면 갈수 ㅇ 0이면 갈수 x
		// 1로 연결돼 있으면 cnt1

	}

	private static int bfs(int y, int x) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { y, x, 1 });
		visited[y][x] = true;
//		int cnt = 1;

		while (!queue.isEmpty()) {
			int current[] = queue.poll();

			for (int i = 0; i < 8; i++) {
				int nx = current[1] + dx[i];
				int ny = current[0] + dy[i];
				int cnt = current[2];

				if (nx < 0 || ny < 0 || nx >= w || ny >= h || visited[ny][nx] || arr[ny][nx] == 0) {
					continue;
				}

				if (!visited[ny][nx] && arr[ny][nx] == 1) {
					queue.add(new int[] { ny, nx, cnt + 1 });
					visited[ny][nx] = true;
					
				}
			}
		}
		return 1;

//		return bfs(ny, nx);
	}
}