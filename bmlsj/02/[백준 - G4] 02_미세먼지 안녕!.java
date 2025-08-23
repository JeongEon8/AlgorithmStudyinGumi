import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

	static int R, C, T;
	static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		R = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);
		T = Integer.parseInt(split[2]);

		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			split = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		for (int t = 0; t < T; t++) {
			spread();
			airPurifier();
		}

		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					ans += map[i][j];
				}
			}
		}

		System.out.println(ans);

	}

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	static void spread() {

		int[][] temp = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {

					int dustAmount = map[i][j] / 5;
					int cnt = 0;

					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];

						if (nx < 0 || nx >= R || ny < 0 || ny >= C)
							continue;
						if (map[nx][ny] == -1)
							continue;

						temp[nx][ny] += dustAmount;
						cnt++;

					}

					map[i][j] -= dustAmount * cnt;

				}

			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += temp[i][j];
			}
		}

	}

	static void airPurifier() {

		int[] top = new int[2];
		boolean check = false;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1) {
					top[0] = i;
					check = true;
					break;
				}
			}

			if (check)
				break;
		}

		topLogic(top[0], 0);
		downLogic(top[0] + 1, 0);

	}

	static void topLogic(int sx, int sy) {

		int dir = 0;
		int x = sx, y = sy;
		int prev = 0;

		while (true) {

			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || nx > sx || ny < 0 || ny >= C) {
				dir = (dir + 1) % 4;
				nx = x + dx[dir];
				ny = y + dy[dir];
			}

			if (nx == sx && ny == sy) {
				map[nx][ny] = -1;
				break;
			}

			int tmp = map[nx][ny];
			map[nx][ny] = prev;
			prev = tmp;

			x = nx;
			y = ny;

		}

	}

	static int[] dx2 = { 0, 1, 0, -1 };
	static int[] dy2 = { 1, 0, -1, 0 };

	static void downLogic(int sx, int sy) {

		int dir = 0;
		int x = sx, y = sy; // 공기 청정기 바로 오른쪽에서 시작
		int prev = 0;

		while (true) {

			int nx = x + dx2[dir];
			int ny = y + dy2[dir];

			if (nx < sx || nx >= R || ny < 0 || ny >= C) {
				dir = (dir + 1) % 4;
				nx = x + dx2[dir];
				ny = y + dy2[dir];
			}

			if (nx == sx && ny == sy) {
				map[nx][ny] = -1;
				break;
			}

			int tmp = map[nx][ny];
			map[nx][ny] = prev;
			prev = tmp;

			x = nx;
			y = ny;

		}

	}
}