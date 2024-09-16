import java.util.Scanner;

public class Main10 {

	static int n, m;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int depthW, depthB;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[m][n];
		visit = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			String str = sc.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int resultW = 0;
		int resultB = 0;

		for (int i = 0; i <m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'W' && !visit[i][j]) { // W인 경우
					depthW = 1;
					findW(i, j); // startX, startY, depth
					resultW += depthW * depthW;
				} else if (map[i][j] == 'B' && !visit[i][j]) {
					depthB = 1;
					findB(i, j);
					resultB += depthB * depthB;
				}
			}
		}

		System.out.println(resultW + " " + resultB);

	}

	private static void findW(int x, int y) {
		// TODO Auto-generated method stub

		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visit[nx][ny]) {
				if (map[nx][ny] == 'W') {
					findW(nx, ny);
					depthW++;
				}
			}
		}
	}
	
	private static void findB(int x, int y) {
		// TODO Auto-generated method stub

		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visit[nx][ny]) {
				if (map[nx][ny] == 'B') {
					findB(nx, ny);
					depthB++;
				}
			}
		}
	}

}
