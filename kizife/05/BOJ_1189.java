import java.util.Scanner;

public class Main {

	static char[][] map;
	static boolean[][] visit;
	static int r, c, k;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		r = sc.nextInt();
		c = sc.nextInt();
		k = sc.nextInt();
		sc.nextLine();

		map = new char[r][c];
		visit = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		count = 0;
		dfs(r - 1, 0, 1); // x, y, depth

		System.out.println(count);

	}

	private static void dfs(int x, int y, int depth) {
		// TODO Auto-generated method stub
		if (x == 0 && y == c - 1) {
			if (depth == k) {
				
				count++;
			}
			return;
		}

		if (depth >= k) {
			return;
		}

		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < r && ny < c && !visit[nx][ny] && map[nx][ny] != 'T') {

				dfs(nx, ny, depth + 1);

			}

		}
		visit[x][y] = false;
	}
}
