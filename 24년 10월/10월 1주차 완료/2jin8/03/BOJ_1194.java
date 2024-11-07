import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 가진 열쇠의 개수가 같더라도 
// 가진 열쇠가 다르면 방문해도 됨
// 비트마스킹으로 획득한 열쇠의 정보를 저장하기!
public class BOJ_1194 {

	static int N, M, KEY = 6, K = 64;
	static char[][] map;
	static boolean[][][] visited;
	static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][K];
		int sx = -1, sy = -1;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '0') {
					sx = i;
					sy = j;
				}
			}
		}
		System.out.println(bfs(sx, sy));
	}

	static int bfs(int sx, int sy) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(sx, sy, 0, 0));
		visited[sx][sy][0] = true;

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			int x = now.x, y = now.y, dist = now.dist;
			if (map[x][y] == '1') { // 출구에 도착
				return dist;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (map[nx][ny] == '#' || visited[nx][ny][now.key])
					continue;

				char next = map[nx][ny];
				// 열쇠가 있는 경우
				if (next >= 'a' && next <= 'f') {
					int key = next - 'a';
					// 해당 열쇠를 이미 획득한 경우, 그냥 방문하기
					if ((now.key & (1 << key)) > 0) {
						queue.offer(new Point(nx, ny, now.key, dist + 1));
						visited[nx][ny][now.key] = true;
					}
					// 해당 열쇠를 획득한 적이 없는 경우
					else {
						int newKey = now.key | (1 << key); // 열쇠 획득
						if (!visited[nx][ny][newKey]) {
							queue.offer(new Point(nx, ny, newKey, dist + 1));
							visited[nx][ny][newKey] = true;
						}
					}
				}
				// 문이 있는 경우
				else if (next >= 'A' && next <= 'F') {
					int door = next - 'A';
					// 문을 열 수 있는 열쇠가 있는 경우
					if ((now.key & (1 << door)) > 0) {
						queue.offer(new Point(nx, ny, now.key, dist + 1));
						visited[nx][ny][now.key] = true;
					}
				}
				// 빈 칸 or 시작 위치 or 출구인 경우
				else {
					queue.offer(new Point(nx, ny, now.key, dist + 1));
					visited[nx][ny][now.key] = true;
				}
			}
		}
		return -1;
	}

	static class Point {
		int x, y, key, dist; // key: 획득한 key 정보, dist: 이동 횟수

		public Point(int x, int y, int key, int dist) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.dist = dist;
		}
	}
}
