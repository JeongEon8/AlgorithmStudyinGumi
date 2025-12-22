import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int n, m;
	static int[][] city;

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	static boolean inCity(int y, int x) {
		return y < m && x < n;
	}

	static boolean bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(0, 0));
		boolean[][] visited = new boolean[m][n];
		visited[0][0] = true;
		while (!q.isEmpty()) {
			Point current = q.poll();
			if (current.y == m - 1 && current.x == n - 1)
				return true;
			if (inCity(current.y + 1, current.x) && !visited[current.y + 1][current.x]
					&& city[current.y + 1][current.x] == 1) {
				visited[current.y + 1][current.x] = true;
				q.add(new Point(current.y + 1, current.x));
			}
			if (inCity(current.y, current.x + 1) && !visited[current.y][current.x + 1]
					&& city[current.y][current.x + 1] == 1) {
				visited[current.y][current.x + 1] = true;
				q.add(new Point(current.y, current.x + 1));
			}
		}

		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		n = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]);
		city = new int[m][n];
		for (int i = 0; i < m; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				city[i][j] = Integer.parseInt(split[j]);
			}
		}
		if (bfs()) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
