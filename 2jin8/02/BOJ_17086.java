import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086 {

	// 안전 거리가 제일 큰 칸 = 상어가 있는 칸까지의 최단 거리가 가장 큰 칸
	static int N, M;
	static int[][] map, dist;
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 }, dy = { 0, 0, 1, -1, 1, -1, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int maxDist = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					maxDist = Math.max(maxDist, bfs(i, j));
			}
		}
		System.out.println(maxDist);
	}

	static int bfs(int sx, int sy) {
		Queue<int[]> queue = new ArrayDeque<>();
		dist = new int[N][M];
		queue.offer(new int[] { sx, sy });
		dist[sx][sy] = 1;

		int safeDist = 0;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0], y = now[1];
			if (dist[x][y] != 1 && map[x][y] == 1) {
				safeDist = dist[x][y] - 1;
				break;
			}

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || dist[nx][ny] != 0)
					continue;

				queue.offer(new int[] { nx, ny });
				dist[nx][ny] = dist[x][y] + 1;
			}
		}
		return safeDist;
	}
}
