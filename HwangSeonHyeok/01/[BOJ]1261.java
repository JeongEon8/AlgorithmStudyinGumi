import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Node implements Comparable<Node> {
		int y, x, cost;

		public Node(int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {

			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int m = Integer.parseInt(split[0]);
		int n = Integer.parseInt(split[1]);
		int[][] maze = new int[n][m];
		int[][] dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			String line = in.readLine();
			for (int j = 0; j < m; j++) {
				maze[i][j] = line.charAt(j) - '0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(0, 0, 0));
		dist[0][0] = 0;
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (now.cost > dist[now.y][now.x])
				continue;
			for (int i = 0; i < 4; i++) {
				int nextY = now.y + dy[i];
				int nextX = now.x + dx[i];
				if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m)
					continue;
				if (dist[nextY][nextX] > now.cost + maze[nextY][nextX]) {
					dist[nextY][nextX] = now.cost + maze[nextY][nextX];
					pq.add(new Node(nextY, nextX, dist[nextY][nextX]));
				}
			}
		}
		System.out.println(dist[n - 1][m - 1]);

	}

}