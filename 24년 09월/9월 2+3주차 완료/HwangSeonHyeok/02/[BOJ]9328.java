import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < t; tc++) {
			String[] split = in.readLine().split(" ");
			int h = Integer.parseInt(split[0]);
			int w = Integer.parseInt(split[1]);
			int H = h + 2;// 확장 h,w
			int W = w + 2;
			char[][] building = new char[H][W];
			for (int i = 1; i <= h; i++) {
				String line = in.readLine();
				for (int j = 1; j <= w; j++) {
					building[i][j] = line.charAt(j - 1);
				}
			}
			String startKeyStr = in.readLine();
			boolean[] hasKey = new boolean[26];
			if (!"0".equals(startKeyStr)) {
				for (int i = 0; i < startKeyStr.length(); i++) {
					hasKey[startKeyStr.charAt(i) - 'a'] = true;
				}
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (i == 0 || j == 0 || i == h + 1 || j == w + 1) {

						building[i][j] = '.';

					}
				}
			}
			int ans = 0;
			boolean[][] visited = new boolean[H][W];
			Queue<Point> q = new ArrayDeque<>();
			q.add(new Point(0, 0));
			while (!q.isEmpty()) {
				Point p = q.poll();
				for (int i = 0; i < 4; i++) {
					int nextY = p.y + dy[i];
					int nextX = p.x + dx[i];
					if (nextY >= 0 && nextY < H && nextX >= 0 && nextX < W && building[nextY][nextX] != '*'
							&& !visited[nextY][nextX]) {
						char next = building[nextY][nextX];
						if (next >= 'a' && next <= 'z') {
							if (!hasKey[next - 'a']) {
								hasKey[next - 'a'] = true;
								visited = new boolean[H][W];
								q.clear();
							}
							visited[nextY][nextX] = true;
							q.add(new Point(nextY, nextX));
						} else if (next >= 'A' && next <= 'Z') {
							visited[nextY][nextX] = true;
							if (hasKey[next - 'A']) {
								q.add(new Point(nextY, nextX));
							}
						} else if (next == '$') {
							ans++;
							visited[nextY][nextX] = true;
							building[nextY][nextX] = '.';
							q.add(new Point(nextY, nextX));
						}else {
							visited[nextY][nextX] = true;
							q.add(new Point(nextY, nextX));
						}
					}
				}
			}
			System.out.println(ans);
		}

	}

}