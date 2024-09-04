import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int m, n, k;
	static int area;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();

		map = new int[m][n];
		visit = new boolean[m][n];

		for (int i = 0; i < k; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			for (int j = y1; j < y2; j++) {
				for (int j2 = x1; j2 < x2; j2++) {
					map[j][j2] = 1;
				}
			}

		}

		for (int j = 0; j < m; j++) {
			for (int j2 = 0; j2 < n; j2++) {
				if (map[j][j2] == 0) { 
					area = 1;
					dfs(j, j2);
					list.add(area);
				}
			}
		}

		Collections.sort(list);

		System.out.println(list.size());

		for (int i : list) {
			System.out.print(i + " ");
		}

	}

	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
//		visit[x][y] = true;
		map[x][y] =1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

//			if (nx >= 0 && ny >= 0 && nx < m && ny < n && map[nx][ny] == 0 && !visit[nx][ny]) {
			if (nx >= 0 && ny >= 0 && nx < m && ny < n && map[nx][ny] == 0) {
				area++;
				dfs(nx, ny);
			}
		}

	}

}
