import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485 {

	static int N;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int idx = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) // N이 0이면 입력이 종료됨
				break;

			map = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append("Problem ").append(idx++).append(": ").append(bfs()).append("\n");
		}
		System.out.println(sb);
	}

	static int bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(0, 0, map[0][0]));
		visited[0][0] = true;

		int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		while (!pq.isEmpty()) {
			// 잃는 루피가 가장 적은 것부터 poll
			Point point = pq.poll();
			// 제일 아래 칸에 도착하면 탐색 종료
			if (point.x == N - 1 && point.y == N - 1) {
				return point.rupee;
			}

			for (int i = 0; i < 4; i++) {
				int nx = point.x + move[i][0];
				int ny = point.y + move[i][1];
				// 범위를 벗어나거나 이미 방문한 지역이면 탐색 X
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny])
					continue;

				pq.offer(new Point(nx, ny, point.rupee + map[nx][ny]));
				visited[nx][ny] = true;
			}
		}
		return -1;
	}

	static class Point implements Comparable<Point> {
		int x, y;
		int rupee; // 잃는 금액

		public Point(int x, int y, int rupee) {
			this.x = x;
			this.y = y;
			this.rupee = rupee;
		}

		@Override
		public int compareTo(Point o) {
			// 잃는 금액을 기준으로 오름차순 정렬
			return this.rupee - o.rupee;
		}
	}
}
