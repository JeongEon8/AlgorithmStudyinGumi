import java.util.Scanner;

public class BOJ_1926 {

	static int n, m;
	static int[][] arr;
	static boolean[][] visit;
	static int count;
	static int result;
	static int max = 0;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1 && !visit[i][j]) {
					count++;
					draw(i, j);
					max = Math.max(max, result);
					result = 0;
				}
			}
		}

		System.out.println(count);
		System.out.println(max);

	}

	private static void draw(int x, int y) {
		// TODO Auto-generated method stub

		visit[x][y] = true;
		result++;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (arr[nx][ny] == 1 && !visit[nx][ny]) {
					draw(nx, ny);
				}
			}
		}

	}

}
