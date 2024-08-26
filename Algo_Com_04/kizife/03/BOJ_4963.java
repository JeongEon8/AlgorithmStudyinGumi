import java.util.Scanner;

public class Main {

	static int[][] map;
	static int[][] visited;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
//	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int w;
	static int h;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {

			// 테스트 케이만큼 반복
			w = sc.nextInt();
			h = sc.nextInt();

			if (w == 0 && h == 0) {
				break;
			}
			
			map = new int[h][w];
			visited = new int[h][w];
			int island = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j] == 1 && visited[i][j] != 1) {
						dfs(i, j); //밑에서 따로 구현해줘야 함!
						island++;
					}
				}
			}
			
			System.out.println(island);

		}
		

	}

	static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		
		visited[x][y] = 1;
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			//nx, n는... 8방 이동한 후 새로운 좌표 
			
			if (nx<0 || ny<0 || nx>=h || ny>=w) continue;
			if (map[nx][ny] == 1 && visited[nx][ny] != 1) dfs(nx, ny);
		}
		
	}
}
