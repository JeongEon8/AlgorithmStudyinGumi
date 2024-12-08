import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_2665 {

	static int N, INF = 2500;
	static int[][] map, minDist;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				// 거리 계산을 위해 흰 방을 0, 검은 방을 1로 바꾸기
				if (chars[j] == '0') map[i][j] = 1;
				else map[i][j] = 0;
			}
		}

		minDist = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(minDist[i], INF);
		}
		System.out.println(dijkstra(0, 0, N - 1, N - 1));
	}

	static int dijkstra(int sx, int sy, int ex, int ey) {
		PriorityQueue<Room> pq = new PriorityQueue<>((r1, r2) -> Integer.compare(r1.d, r2.d));
		pq.offer(new Room(sx, sy, 0));
		minDist[sx][sy] = 0;

		while (!pq.isEmpty()) {
			Room now = pq.poll();
			if (now.x == ex && now.y == ey)
				break;

			if (visited[now.x][now.y])
				continue;
			visited[now.x][now.y] = true;

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;

				if (!visited[nx][ny] && minDist[nx][ny] > minDist[now.x][now.y] + map[nx][ny]) {
					minDist[nx][ny] = minDist[now.x][now.y] + map[nx][ny];
					pq.offer(new Room(nx, ny, minDist[nx][ny]));
				}
			}
		}
		return minDist[ex][ey];
	}

	static class Room {
		int x, y, d; // d: 지나가는 검은 방의 수

		public Room(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
