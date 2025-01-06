import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int n;
//	static int count;
	static ArrayList<Integer> result = new ArrayList(); 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n][n];
		visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j) - '0';
//				System.out.println(map[i][j]);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					int count = dfs(i, j);
					result.add(count);
				}
			}
		}
		
		Collections.sort(result);
		System.out.println(result.size());
		for (int i : result) {
			System.out.println(i);
		}
		

	}

	private static int dfs(int x, int y) {
		// TODO Auto-generated method stub
		visit[x][y] = true; // 방문처리
		int count = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (map[nx][ny] == 1 && !visit[nx][ny]) {
					count += dfs(nx, ny);
				}
			}
		}
		return count;
	}

}
