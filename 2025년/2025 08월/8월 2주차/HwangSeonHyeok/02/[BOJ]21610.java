import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] buckets;
	static boolean[][] cloud;
	static int n, m;
	static int[] directionX = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] directionY = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] crossX = { -1, -1, 1, 1 };
	static int[] crossY = { 1, -1, -1, 1 };

	static boolean inRange(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < n;
	}

	static void rainDance(int direction, int count) {
		int dx = directionX[direction] * count;
		int dy = directionY[direction] * count;
		boolean[][] rainyArea = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (cloud[i][j]) {
					int rainX = (j + dx % n + n) % n;
					int rainY = (i + dy % n + n) % n;
					buckets[rainY][rainX]++;
					cloud[i][j] = false;
					rainyArea[rainY][rainX] = true;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (rainyArea[i][j]) {
					for (int k = 0; k < 4; k++) {
						int nextX = j + crossX[k];
						int nextY = i + crossY[k];
						if (inRange(nextY, nextX) && buckets[nextY][nextX] >= 1) {
							buckets[i][j]++;
						}
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!rainyArea[i][j] && buckets[i][j] >= 2) {
					buckets[i][j] -= 2;
					cloud[i][j] = true;
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		buckets = new int[n][n];
		cloud = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < n; j++) {
				buckets[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cloud[n - 1][0] = true;
		cloud[n - 1][1] = true;
		cloud[n - 2][0] = true;
		cloud[n - 2][1] = true;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int direction = Integer.parseInt(st.nextToken()) - 1;
			int count = Integer.parseInt(st.nextToken());
			rainDance(direction, count);
		}
		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans += buckets[i][j];
			}
		}
		System.out.println(ans);

	}

}