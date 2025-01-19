import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14923 {

	static int N, M, Hx, Hy, Ex, Ey;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Hx = Integer.parseInt(st.nextToken());
		Hy = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Ex = Integer.parseInt(st.nextToken());
		Ey = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1][2]; // [][][0]: 벽 부수지 않음, [][][1]: 벽 부숨
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs());
	}

	static int bfs() {
		Queue<Pos> queue = new ArrayDeque<>();
		queue.offer(new Pos(Hx, Hy, 0, 0));
		visited[Hx][Hy][0] = true;

		while (!queue.isEmpty()) {
			Pos now = queue.poll();
			int x = now.x, y = now.y;
			if (x == Ex && y == Ey)
				return now.d;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx <= 0 || ny <= 0 || nx > N || ny > M || visited[nx][ny][now.crash])
					continue;

				// 현재 칸이 벽인 경우 & 벽을 부술 기회가 남은 경우
				if (map[nx][ny] == 1 && now.crash == 0 && !visited[nx][ny][1]) {
					queue.offer(new Pos(nx, ny, now.d + 1, 1));
					visited[nx][ny][1] = true;
				} 
				// 빈 칸이면 그냥 이동하기
				else if (map[nx][ny] == 0) {
					queue.offer(new Pos(nx, ny, now.d + 1, now.crash));
					visited[nx][ny][now.crash] = true;
				}
			}
		}
		return -1;
	}

	static class Pos {
		int x, y, d, crash;

		public Pos(int x, int y, int d, int crash) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.crash = crash;
		}
	}
}
