import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);

		split = br.readLine().split(" ");
		int sx = Integer.parseInt(split[0]);
		int sy = Integer.parseInt(split[1]);
		int dir = Integer.parseInt(split[2]); // 0:북, 1:동, 2:남, 3:서

		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			split = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		clean(sx, sy, dir);
		System.out.println(cnt);
	}

	// 북동남서(상우하좌) -> 서남동북
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	static int cnt = 0;

	static void clean(int x, int y, int dir) {

		while (true) {

			if (!visited[x][y]) {
				visited[x][y] = true;
				cnt++;
			}

			boolean moved = false;

			for (int i = 0; i < 4; i++) {
				dir = (dir + 3) % 4;
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}

				if (!visited[nx][ny] && map[nx][ny] == 0) {
					visited[nx][ny] = true;
					moved = true;
					x = nx;
					y = ny;
					cnt++;
					break;
				}
			}

			if (!moved) { // 주변에 청소되지 않은 빈칸이 없는 경우
				// 뒤쪽 칸이 벽이 아닌 경우
				int bx = x - dx[dir];
				int by = y - dy[dir];
				if (bx >= 0 && by >= 0 && bx < N && by < M && map[bx][by] != 1) {
					x = bx;
					y = by;
				} else {
					break; // 벽이면 종료
				}

			}
		}

	}
}
