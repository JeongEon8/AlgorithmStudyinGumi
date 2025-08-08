import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int R, C;
	static String[][] map;
	static int[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		R = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);

		map = new String[R][C];
		visited = new int[R][C];
		int sx = -1, sy = -1;
		int ex = -1, ey = -1;
		for (int i = 0; i < R; i++) {
			split = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = split[j];
				if (map[i][j].equals("S")) {
					sx = i;
					sy = j;
				}

				if (map[i][j].equals("D")) {
					ex = i;
					ey = j;
				}
			}
		}

		// '*' : 물, 'X' : 돌, 'D' : 비버굴, 'S' : 고슴
		move(sx, sy);
		System.out.println(visited[ex][ey] == 0 ? "KAKTUS" : visited[ex][ey] - 1);

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void move(int x, int y) {

		Queue<int[]> queue = new ArrayDeque<int[]>();
		Queue<int[]> water = new ArrayDeque<int[]>();
		queue.offer(new int[] { x, y });
		visited[x][y] = 1;

		// 물 위치
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j].equals("*")) {
					water.offer(new int[] { i, j });
				}
			}
		}

		while (!queue.isEmpty()) {

			// 물 먼저 이동
			int waterSize = water.size();
			for (int i = 0; i < waterSize; i++) {
				int[] curr = water.poll();
				int wx = curr[0];
				int wy = curr[1];

				for (int d = 0; d < 4; d++) {
					int nx = wx + dx[d];
					int ny = wy + dy[d];

					if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
						continue;
					}

					if (map[nx][ny].equals(".")) {
						map[nx][ny] = "*";
						water.offer(new int[] { nx, ny });
					}
				}
			}

			// 고슴도치 이동
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] curr = queue.poll();
				x = curr[0];
				y = curr[1];

				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
						continue;
					}

					if (map[nx][ny].equals("D")) {
						visited[nx][ny] = visited[x][y] + 1;
						return;
					}

					if (visited[nx][ny] == 0 && map[nx][ny].equals(".")) {
						visited[nx][ny] = visited[x][y] + 1;
						queue.offer(new int[] { nx, ny });
					}
				}
			}

		}

	}

}
