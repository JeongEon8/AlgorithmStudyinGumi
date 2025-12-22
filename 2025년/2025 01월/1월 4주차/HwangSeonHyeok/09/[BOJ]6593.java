import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static class Pos {
		int l, r, c, step;

		public Pos(int l, int r, int c, int step) {
			this.l = l;
			this.r = r;
			this.c = c;
			this.step = step;
		}

	}

	static Pos startPoint, endPoint;
	static boolean[][][] building, visited;
	static int L, R, C;
	static int[] dl = { 1, -1, 0, 0, 0, 0 };
	static int[] dr = { 0, 0, 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 0, 0, 1, -1 };

	static int bfs() {

		Queue<Pos> q = new ArrayDeque<Pos>();
		q.add(startPoint);
		visited[startPoint.l][startPoint.r][startPoint.c] = true;
		while (!q.isEmpty()) {
			Pos current = q.poll();
			for (int i = 0; i < 6; ++i) {
				int nextl = current.l + dl[i];
				int nextr = current.r + dr[i];
				int nextc = current.c + dc[i];
				if (building[nextl][nextr][nextc] && !visited[nextl][nextr][nextc]) {
					if (nextl == endPoint.l && nextr == endPoint.r && nextc == endPoint.c)
						return current.step + 1;
					visited[nextl][nextr][nextc] = true;
					q.add(new Pos(nextl, nextr, nextc, current.step + 1));
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		while (true) {
			String[] split = in.readLine().split(" ");
			L = Integer.parseInt(split[0]);
			R = Integer.parseInt(split[1]);
			C = Integer.parseInt(split[2]);
			if (L == 0 && R == 0 && C == 0) {
				break;
			}
			building = new boolean[L + 2][R + 2][C + 2];
			visited = new boolean[L + 2][R + 2][C + 2];
			String line;
			for (int i = 1; i <= L; ++i) {
				for (int j = 1; j <= R; ++j) {
					line = in.readLine();
					for (int k = 1; k <= C; ++k) {
						char c = line.charAt(k - 1);
						if (c != '#') {
							building[i][j][k] = true;
						}
						if (c == 'S') {
							startPoint = new Pos(i, j, k, 0);
						} else if (c == 'E') {
							endPoint = new Pos(i, j, k, 0);
						}
					}
				}
				line = in.readLine();
			}
			int ans = bfs();
			if (ans == -1) {
				sb.append("Trapped!\n");
			} else {
				sb.append("Escaped in " + ans + " minute(s).\n");
			}

		}
		System.out.println(sb);

	}

}