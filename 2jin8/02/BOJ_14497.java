import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14497 {

	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken()) - 1;
		int sy = Integer.parseInt(st.nextToken()) - 1;
		int ex = Integer.parseInt(st.nextToken()) - 1;
		int ey = Integer.parseInt(st.nextToken()) - 1;

		map = new char[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		bfs(sx, sy, ex, ey);
	}

	static void bfs(int sx, int sy, int ex, int ey) {
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.jump, n2.jump));
		pq.offer(new Node(sx, sy, 0));
		visited[sx][sy] = true;

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			// 초코바를 가진 학생에 도달한 경우
			if (now.x == ex && now.y == ey) {
				System.out.println(now.jump);
				break;
			}

			for (int j = 0; j < 4; j++) {
				int nx = now.x + dx[j];
				int ny = now.y + dy[j];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny])
					continue;

				// 장애물이 없으면 계속해서 퍼짐 (점프 횟수 그대로)
				// 장애물이 있으면 퍼지는 것이 멈춤 (점프 횟수 + 1)
				int newJump = (map[nx][ny] == '0' ? now.jump : now.jump + 1);
				pq.offer(new Node(nx, ny, newJump));
				visited[nx][ny] = true;
			}
		}
	}

	static class Node {
		int x, y, jump;

		public Node(int x, int y, int jump) {
			this.x = x;
			this.y = y;
			this.jump = jump;
		}
	}
}
