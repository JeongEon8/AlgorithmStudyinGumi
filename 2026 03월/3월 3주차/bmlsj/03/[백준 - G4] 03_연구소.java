import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair {
	int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Main {

	static int[][] map;
	static int n, m;
	static int answer = -1;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		map = new int[n][m];
		List<Pair> walls = new ArrayList<Pair>();
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (map[i][j] == 0) { // 빈칸
					walls.add(new Pair(i, j));
				}
			}
		}

		combinations(walls, 0, 0);
		System.out.println(answer);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void combinations(List<Pair> walls, int start, int depth) {
		if (3 == depth) {

			int[][] temp = new int[n][m];

			for (int i = 0; i < n; i++) {
				temp[i] = map[i].clone();
			}

			spreadVirus(temp);

			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (temp[i][j] == 0)
						count++;
				}
			}

			answer = Math.max(answer, count);

			return;
		}

		for (int i = start; i < walls.size(); i++) {
			Pair pair = walls.get(i);
			map[pair.x][pair.y] = 1;
			combinations(walls, i + 1, depth + 1);
			map[pair.x][pair.y] = 0;

		}
	}

	static void spreadVirus(int[][] tmpMap) {

		Queue<Pair> queue = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tmpMap[i][j] == 2) {
					queue.offer(new Pair(i, j));
				}
			}
		}

		while (!queue.isEmpty()) {

			Pair curr = queue.poll();

			int x = curr.x;
			int y = curr.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;

				if (tmpMap[nx][ny] == 0) {
					tmpMap[nx][ny] = 2;
					queue.offer(new Pair(nx, ny));

				}
			}

		}

	}

}