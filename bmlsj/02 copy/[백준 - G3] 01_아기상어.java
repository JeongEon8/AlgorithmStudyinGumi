import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	static class Node implements Comparator<Node> {
		int x, y, size, dis;

		Node() {
		}

		Node(int x, int y, int size, int dis) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.dis = dis;
		}

		@Override
		public int compare(Node o1, Node o2) {
			if (o1.dis != o2.dis)
				return o1.dis - o2.dis;
			if (o1.x != o2.x)
				return o1.x - o2.x;
			return o1.y - o2.y;
		}
	}

	static int[][] map;
	static int N;
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		int sx = -1, sy = -1;
		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(split[j]);
				if (map[i][j] == 9) {
					sx = i;
					sy = j;
					map[i][j] = 0;
				}
			}

		}

		cnt = 0;
		int size = 2;
		int eat = 0;
		while (true) {

			PriorityQueue<Node> queue = yum(sx, sy, size);
			if (!queue.isEmpty()) {
				Node curr = queue.poll();
				map[curr.x][curr.y] = 0;
				sx = curr.x;
				sy = curr.y;
				cnt += curr.dis;
			
				eat++;
				if (eat == size) {  // 크기만큼 먹으면 size up 
					size++;
					eat = 0;
				}
	
			} else {
				break;
			}
		}

		System.out.println(cnt);

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;

	static PriorityQueue<Node> yum(int sx, int sy, int size) {

		PriorityQueue<Node> queue = new PriorityQueue<>(new Node());
		visited = new boolean[N][N];
		visited[sx][sy] = true;

		Queue<int[]> bfs = new ArrayDeque<int[]>();
		bfs.offer(new int[] { sx, sy, 0 }); // x, y, 거리

		while (!bfs.isEmpty()) {
			int[] curr = bfs.poll();
			int x = curr[0], y = curr[1], dis = curr[2];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				if (visited[nx][ny])
					continue;
				if (map[nx][ny] > size)
					continue;

				visited[nx][ny] = true;

				if (map[nx][ny] > 0 && map[nx][ny] < size) {
					// 먹을 수 있는 물고기만
					queue.offer(new Node(nx, ny, map[nx][ny], dis + 1));
				}

				// 빈칸이나 같은 크기면 이동 가능
				bfs.offer(new int[] { nx, ny, dis + 1 });
			}
		}

		return queue;
	}
}

