import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int N, M;
	static int[][] map, count;
	static boolean[][] visited;

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);

		map = new int[N][M];
		count = new int[N][M];
		Queue<Node> ices = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			split = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(split[j]);
				if (map[i][j] > 0) {
					ices.offer(new Node(i, j));
				}
			}
		}

		// 1. 얼음을 큐에 넣고, BFS로 인접한 바다 수만큼 빙산을 녹인다.
		// 2. 한번이 끝나면, 덩어리가 몇개인지 DFS로 센다..?
		int year = 0;
		while (true) {
			int cnt = countArea();
			if (cnt == 0) {
				System.out.println(0);
				break;
			}
			if (cnt >= 2) {
				System.out.println(year);
				break;
			}
			ices = meltingIce(ices);
			year++;

		}


	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int countArea() {

		visited = new boolean[N][M];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] > 0) {
					dfs(i, j);
					cnt++;
				}
			}
		}

		return cnt;

	}

	static void dfs(int x, int y) {

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
				continue;
			}

			if (!visited[nx][ny] && map[nx][ny] > 0) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}

	static Queue<Node> meltingIce(Queue<Node> queue) {

		Queue<Node> nextIces = new ArrayDeque<>();

		while (!queue.isEmpty()) {

			Node curr = queue.poll();
			int cnt = 0;

			for (int i = 0; i < 4; i++) {

				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}

				if (map[nx][ny] == 0) {
					cnt++;
				}
			}

			count[curr.x][curr.y] = cnt;
		}

		// 얼음 녹이기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) {
					map[i][j] -= count[i][j];
					if (map[i][j] < 0)
						map[i][j] = 0;
					if (map[i][j] > 0) {  // 다음 녹일 얼음 위치
						nextIces.offer(new Node(i, j));
					}
				}
			}
		}
		
		return nextIces;

	}

}
