import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Node {
		int x, y, broken;

		Node(int x, int y, int broken) {
			this.x = x;
			this.y = y;
			this.broken = broken; // 0: 아직 / 1: 부숨
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);

		map = new int[N][M];
		visited = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		System.out.println(breakWalls());

	}

	static int breakWalls() {

		Queue<Node> queue = new ArrayDeque<Node>();

		queue.offer(new Node(0, 0, 0));
		visited[0][0][0] = true;

		int[][] dist = new int[N][M];
		dist[0][0] = 1;

		while (!queue.isEmpty()) {

			Node curr = queue.poll();

			if (curr.x == N - 1 && curr.y == M - 1) {
				return dist[curr.x][curr.y];
			}

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}

				// 벽x
				if (!visited[nx][ny][curr.broken] && map[nx][ny] == 0) {
					visited[nx][ny][curr.broken] = true;
					dist[nx][ny] = dist[curr.x][curr.y] + 1;
					queue.offer(new Node(nx, ny, curr.broken));
				}

				// 벽o이고 안부쉈을 때
				if (!visited[nx][ny][1] && curr.broken == 0 && map[nx][ny] == 1) {
					visited[nx][ny][1] = true;
					dist[nx][ny] = dist[curr.x][curr.y] + 1;
					queue.offer(new Node(nx, ny, 1));
				}
			}
		}

		return -1;
	}

}
