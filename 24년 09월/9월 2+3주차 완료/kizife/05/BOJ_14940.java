import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int n, m;
	static int[][] map;
	static Queue<Point> queue = new LinkedList<>();
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Point {
		int x;
		int y;
		int col;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] == 2) {
					queue.add(new Point(i, j));
					bfs(i, j);
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) {
					map[i][j] = map[i][j] -2;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			int nowX = now.x;
			int nowY = now.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = nowX + dx[i];
				int ny = nowY + dy[i];
				
				if (nx>=0 && ny>=0 && nx<n && ny<m ) {
					if (map[nx][ny] == 1) {
						queue.add(new Point(nx, ny));
						map[nx][ny] = map[nowX][nowY] + 1;
					}
				}
			}
			
			
		}

		
	}

}
