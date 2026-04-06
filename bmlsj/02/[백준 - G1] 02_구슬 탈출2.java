import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	/*
	 * 빨간 구슬이 구멍에 빠져야함. 파란구슬이 먼저 빠지면 안됨 방향 전환한 최소 횟수를 구하는 것
	 */
	static int N, M;
	static char[][] map;
	static int rx, ry, bx, by, ex, ey;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		// N, M
		input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		// 지도
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = input[j].charAt(0);
				if (map[i][j] == 'R') {
					rx = i;
					ry = j;
				} else if (map[i][j] == 'B') {
					bx = i;
					by = j;
				} else if (map[i][j] == 'O') {
					ex = i;
					ey = j;
				}
			}
		}

		int ans = bfs();
		System.out.println(ans);

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int bfs() {

		Queue<int[]> q = new ArrayDeque<>();
		boolean[][][][] visited = new boolean[N][M][N][M];

		q.offer(new int[] { rx, ry, bx, by, 1 });
		visited[rx][ry][bx][by] = true;

		while (!q.isEmpty()) {

			int[] cur = q.poll();
			rx = cur[0];
			ry = cur[1];
			bx = cur[2];
			by = cur[3];
			int cnt = cur[4];

			if (cnt > 10) {
				return -1;
			}

			for (int d = 0; d < 4; d++) {
				int rnx = rx;
				int rny = ry;
				int bnx = bx;
				int bny = by;

				boolean isRed = false;
				boolean isBlue = false;
				int rDist = 0, bDist = 0;

				// red
				while (map[rnx + dx[d]][rny + dy[d]] != '#') {

					rnx += dx[d];
					rny += dy[d];
					rDist++;

					if (map[rnx][rny] == 'O') {// 이동 후가 구멍일 경우
						isRed = true;
						break;
					}
				}

				// blue
				while (map[bnx + dx[d]][bny + dy[d]] != '#') {

					bnx += dx[d];
					bny += dy[d];
					bDist++;

					if (map[bnx][bny] == 'O') {// 이동 후가 구멍일 경우
						isBlue = true;
						break;
					}
				}

				if (isBlue) { // 파란 구슬이 먼저 도착
					continue;
				}

				if (isRed && !isBlue) {
					return cnt;
				}

				if (rnx == bnx && rny == bny) {
					if (rDist > bDist) { // 빨간 구슬이 더 멀리 있을 때(파란 구슬 전칸으로 넘겨야함)
						rnx -= dx[d];
						rny -= dy[d];
					} else {
						bnx -= dx[d];
						bny -= dy[d];
					}
				}

				if (!visited[rnx][rny][bnx][bny]) {
					visited[rnx][rny][bnx][bny] = true;
					q.offer(new int[] { rnx, rny, bnx, bny, cnt + 1 });
				}

			}
		}

		return -1;

	}

}