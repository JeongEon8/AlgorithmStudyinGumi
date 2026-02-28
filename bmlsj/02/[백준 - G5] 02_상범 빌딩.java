import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static String[][][] map;
	static int L, R, C;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] split = br.readLine().split(" ");
			L = Integer.parseInt(split[0]);
			R = Integer.parseInt(split[1]);
			C = Integer.parseInt(split[2]);

			if (L == 0 && R == 0 && C == 0)
				break;

			map = new String[L][R][C];
			int sx = 0, sy = 0, sz = 0;
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String line = br.readLine();
					for (int k = 0; k < C; k++) {
						map[i][j][k] = String.valueOf(line.charAt(k));
						if (map[i][j][k].equals("S")) {
							sx = i;
							sy = j;
							sz = k;
						}
					}
				}
				br.readLine();
			}

			visited = new boolean[L][R][C];
			int ans = escape(sx, sy, sz);
			if (ans != -1) {
				System.out.printf("Escaped in %d minute(s).\n", ans);
			} else {
				System.out.println("Trapped!");
			}

		}

	}

	static boolean[][][] visited;
	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };

	static int escape(int z, int x, int y) {

		visited[z][x][y] = true;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { z, x, y, 0 });

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();
			z = curr[0];
			x = curr[1];
			y = curr[2];
			int time = curr[3];

			for (int d = 0; d < 6; d++) {
				int nz = z + dz[d];
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (nz < 0 || nx < 0 || ny < 0 || nz >= L || nx >= R || ny >= C)
					continue;

				if (visited[nz][nx][ny])
					continue;

				if (map[nz][nx][ny].equals("#"))
					continue;

				if (map[nz][nx][ny].equals("E")) {
					return time + 1;
				}

				if (!visited[nz][nx][ny] && map[nz][nx][ny].equals(".")) {
					visited[nz][nx][ny] = true;
					queue.offer(new int[] { nz, nx, ny, time + 1 });
				}
			}
		}

		return -1;
	}

}

