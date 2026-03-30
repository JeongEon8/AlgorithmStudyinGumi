import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[][] map;
	static int N, Q, size;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		Q = Integer.parseInt(split[1]);

		size = 1 << N;
		map = new int[size][size];
		for (int i = 0; i < size; i++) {
			split = br.readLine().split(" ");
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		String[] Level = br.readLine().split(" ");
		for (String L : Level) {
			int level = Integer.parseInt(L);
			splitMap(level);
			melt();
		}

		System.out.println(getTotalIce());
		System.out.println(getMaxBlock());
	}

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	static void splitMap(int level) {

		int step = 1 << level;
		int[][] newMap = new int[size][size];

		for (int i = 0; i < size; i += step) {
			for (int j = 0; j < size; j += step) {
				for (int x = 0; x < step; x++) {
					for (int y = 0; y < step; y++) {
						newMap[i + y][j + step - 1 - x] = map[i + x][j + y];
					}
				}
			}
		}

		map = newMap;

	}

	static void melt() {

		int[][] rotated = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];

					if (nx < 0 || ny < 0 || nx >= size || ny >= size) {
						continue;
					}

					if (map[nx][ny] > 0) {
						cnt++;
					}
				}

				if (map[i][j] > 0 && cnt < 3) {
					rotated[i][j] = map[i][j] - 1;
				} else {
					rotated[i][j] = map[i][j];
				}
			}
		}

		map = rotated;

	}

	static int getTotalIce() {

		int sum = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] <= 0)
					continue;
				sum += map[i][j];
			}
		}
		return sum;
	}

	static int getMaxBlock() {

		int maxBlock = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] > 0) {
					maxBlock = Math.max(bfs(i, j), maxBlock);
				}
			}
		}

		return maxBlock;
	}

	static boolean[][] visited;

	static int bfs(int x, int y) {

		int cnt = 1;
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { x, y });

		visited = new boolean[size][size];
		visited[x][y] = true;

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();

			x = curr[0];
			y = curr[1];

			for (int d = 0; d < 4; d++) {

				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || ny < 0 || nx >= size || ny >= size)
					continue;

				if (!visited[nx][ny] && map[nx][ny] > 0) {
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny });
					cnt++;
				}
			}
		}

		return cnt;
	}
}