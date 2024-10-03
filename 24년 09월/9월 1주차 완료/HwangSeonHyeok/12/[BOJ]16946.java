import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] graph = new int[n][m];
		int[][] graph2 = new int[n][m];
		List<Integer> spaceList = new ArrayList<>();
		List<Point> wList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < m; j++) {
				graph[i][j] = line.charAt(j) - '0';
				graph2[i][j] = 0;
				if (graph[i][j] == 1)
					wList.add(new Point(i, j));
			}
		}
		int spaceNo = 0;
		spaceList.add(0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 0 && graph2[i][j]==0) {
					spaceNo++;
					int cnt = 1;
					Queue<Point> q = new ArrayDeque<>();
					q.add(new Point(i, j));
					graph2[i][j] = spaceNo;
					while (!q.isEmpty()) {
						Point current = q.poll();
						for (int k = 0; k < 4; k++) {
							int nexty = current.y + dy[k];
							int nextx = current.x + dx[k];
							if (nexty >= 0 && nextx >= 0 && nexty < n && nextx < m && graph[nexty][nextx] == 0 && graph2[nexty][nextx]==0) {
								graph2[nexty][nextx] = spaceNo;
								q.add(new Point(nexty, nextx));
								cnt++;
							}
						}
					}
					spaceList.add(cnt);
				}
			}
		}
		for (Point w : wList) {
            Set<Integer> adjacentSpaces = new HashSet<>();
            int cnt = 1;
            for (int i = 0; i < 4; i++) {
                int nexty = w.y + dy[i];
                int nextx = w.x + dx[i];
                if (nexty >= 0 && nextx >= 0 && nexty < n && nextx < m && graph[nexty][nextx] == 0) {
                    int spaceIndex = graph2[nexty][nextx];
                    if (adjacentSpaces.add(spaceIndex)) {
                        cnt += spaceList.get(spaceIndex);
                    }
                }
            }
            graph[w.y][w.x] = cnt % 10;
        }
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(graph[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);

	}

}