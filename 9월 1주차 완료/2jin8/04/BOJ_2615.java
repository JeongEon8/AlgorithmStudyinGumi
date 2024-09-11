import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2615 {
	static final int N = 19;
	static int[][] map = new int[N][N];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if (map[i][j] != 0) {
					if (checkRow(i, j, map[i][j]) || checkCol(i, j, map[i][j]) || checkLCross(i, j, map[i][j])
							|| checkRCross(i, j, map[i][j])) {
						System.out.println(map[i][j]);
						System.out.println((i + 1) + " " + (j + 1));
						return;
					}
				}
			}
		}
		System.out.println(0); // 승부가 결정되지 않은 경우
	}

	static boolean checkRow(int x, int y, int bw) {
		int cnt = 1; // (x, y)
		// 왼쪽
		for (int i = y - 1; i >= 0; i--) {
			if (map[x][i] != bw)
				break;

			cnt++;
		}

		// 오른쪽
		for (int i = y + 1; i < N; i++) {
			if (map[x][i] != bw)
				break;

			cnt++;
		}
		return cnt == 5;
	}

	static boolean checkCol(int x, int y, int bw) {
		int cnt = 1;
		// 위
		for (int i = x - 1; i >= 0; i--) {
			if (map[i][y] != bw)
				break;

			cnt++;
		}
		// 아래
		for (int i = x + 1; i < N; i++) {
			if (map[i][y] != bw)
				break;

			cnt++;
		}
		return cnt == 5;
	}

	static boolean checkLCross(int x, int y, int bw) {
		int cnt = 1;
		// 좌상단
		for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
			if (map[i][j] != bw)
				break;

			cnt++;
		}
		// 좌하단
		for (int i = x + 1, j = y + 1; i < N && j < N; i++, j++) {
			if (map[i][j] != bw)
				break;

			cnt++;
		}
		return cnt == 5;
	}

	static boolean checkRCross(int x, int y, int bw) {
		int cnt = 1;
		// 우상단
		for (int i = x - 1, j = y + 1; i >= 0 && j < N; i--, j++) {
			if (map[i][j] != bw)
				break;

			cnt++;
		}

		// 우하단
		for (int i = x + 1, j = y - 1; i < N && j >= 0; i++, j--) {
			if (map[i][j] != bw)
				break;

			cnt++;
		}
		return cnt == 5;
	}
}
