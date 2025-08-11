import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {

	private static int N, M;
	private static int[][] map;

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
		for (int i = 0; i < N; i++) {
			split = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		// 외부에서 접근 가능한 0만 외부 벽이라 간주
		// 외부에서 만난 치즈는 배열에 저장 후, 한시간 후 녹인다
		int hour = 0, cnt = 0;
		while (true) {

			ArrayList<Node> melt = findWall();

			if (melt.isEmpty()) {
				System.out.println(hour);
				System.out.println(cnt); // 마지막 치즈 개수
				break;
			}

			cnt = melt.size(); // melt.size()가 항상 유효함
			getCheese(melt);
			hour++;

		}

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void getCheese(ArrayList<Node> melt) {

		for (Node node : melt) {
			map[node.x][node.y] = 0;
		}

	}

	static ArrayList<Node> findWall() {

		Queue<Node> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		ArrayList<Node> toMelt = new ArrayList<>();
		queue.offer(new Node(0, 0));
		visited[0][0] = true;

		while (!queue.isEmpty()) {

			Node curr = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}

				if (!visited[nx][ny] && map[nx][ny] == 0) {
					queue.offer(new Node(nx, ny));
					visited[nx][ny] = true;
				} else if (!visited[nx][ny] && map[nx][ny] == 1) {
					toMelt.add(new Node(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}

		return toMelt;

	}

}
