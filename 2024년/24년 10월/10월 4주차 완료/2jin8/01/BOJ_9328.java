import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9328 {

	static int h, w, KEY;
	static char[][] map;
	static int[][] visited;
	static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			System.out.println(1 << 26);
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			map = new char[h + 2][w + 2];
			visited = new int[h + 2][w + 2];
			for (int i = 0; i < h + 2; i++) {
				Arrays.fill(map[i], '.');
				Arrays.fill(visited[i], -1); // 열쇠가 없으면 열쇠 정보가 0이므로 -1로 초기화 해줘야 함..!
			}

			for (int i = 1; i <= h; i++) {
				String line = br.readLine();
				for (int j = 1; j <= w; j++) {
					map[i][j] = line.charAt(j - 1);
				}
			}

			KEY = 0;
			char[] keys = br.readLine().toCharArray();
			for (char key : keys) {
				if (key != '0') {
					KEY |= 1 << (key - 'a');
				}
			}
			sb.append(bfs(new Point(0, 0))).append("\n");
		}
		System.out.println(sb);
	}

	static int bfs(Point start) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start.x][start.y] = KEY;

		int docs = 0;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			System.out.println("(" + now.x + ", " + now.y + ")");

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length)
					continue;

				// 벽이거나 이미 동일한 열쇠 정보로 방문한 경우
				if (map[nx][ny] == '*' || visited[nx][ny] == KEY)
					continue;

				char status = map[nx][ny];
				if (status >= 'A' && status <= 'Z') { // 문
					int door = status - 'A';
					if ((KEY & (1 << door)) == 0) { // 문을 열 수 있는 열쇠가 없는 경우라면 그냥 넘어가기
						continue;
					}
				} else if (status >= 'a' && status <= 'z') { // 열쇠
					int key = status - 'a';
					KEY |= (1 << key);
				} else if (status == '$') { // 문서
					docs++;
				}

				queue.offer(new Point(nx, ny));
				visited[nx][ny] = KEY;
				map[nx][ny] = '.'; // 이미 방문한 곳은 열쇠를 획득했고 문도 열 수 있고 문서도 획득했으므로 빈 칸으로 변경하기
			}
		}
		return docs;
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
