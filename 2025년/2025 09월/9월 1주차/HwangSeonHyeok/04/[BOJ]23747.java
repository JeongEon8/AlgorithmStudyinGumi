import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int row, column;

		public Point(int row, int column) {
			this.row = row;
			this.column = column;
		}

	}

	static boolean inRange(int row, int column) {
		return row >= 0 && row < r && column >= 0 && column < c;
	}

	static int r, c;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		char[][] isekai = new char[r][c];
		char[][] ans = new char[r][c];
		for (int i = 0; i < r; i++) {
			String row = in.readLine();
			for (int j = 0; j < c; j++) {
				isekai[i][j] = row.charAt(j);
				ans[i][j] = '#';
			}
		}
		st = new StringTokenizer(in.readLine());
		int currentR = Integer.parseInt(st.nextToken()) - 1;
		int currentC = Integer.parseInt(st.nextToken()) - 1;
		char[] actions = in.readLine().toCharArray();
		for (char action : actions) {
			if (action == 'W') {
				if (ans[currentR][currentC] == '.')
					continue;
				char current = isekai[currentR][currentC];
				Queue<Point> q = new ArrayDeque<>();
				q.add(new Point(currentR, currentC));
				ans[currentR][currentC] = '.';
				while (!q.isEmpty()) {
					Point p = q.poll();
					for (int i = 0; i < 4; i++) {
						int nextR = p.row + dy[i];
						int nextC = p.column + dx[i];
						if (inRange(nextR, nextC) && ans[nextR][nextC]=='#' && current == isekai[nextR][nextC]) {
							ans[nextR][nextC] = '.';
							q.add(new Point(nextR, nextC));
						}
					}

				}
			} else {
				int dir = 0;
				if (action == 'D') {
					dir = 1;
				} else if (action == 'L') {
					dir = 2;
				} else if (action == 'R') {
					dir = 3;
				}
				currentR += dy[dir];
				currentC += dx[dir];
			}
		}
		ans[currentR][currentC] = '.';
		for (int i = 0; i < 4; i++) {
			int tmpR = currentR + dy[i];
			int tmpC = currentC + dx[i];
			if (inRange(tmpR, tmpC)) {
				ans[tmpR][tmpC] = '.';
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r; i++) {
			sb.append(ans[i]).append("\n");
		}
		System.out.println(sb);
	}

}