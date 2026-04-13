import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[][] grid;
	static boolean visited[][];
	static int N;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				grid[i][j] = line.charAt(j);
			}
		}

		// 승지가 dfs로 풀었대
		// 색약 x
		visited = new boolean[N][N];
		int normalCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false && grid[i][j] == 'R') {
					dfs(i, j, 'R');
					normalCnt++;
				}
				if (visited[i][j] == false && grid[i][j] == 'G') {
					dfs(i, j, 'G');
					normalCnt++;
				}
				if (visited[i][j] == false && grid[i][j] == 'B') {
					dfs(i, j, 'B');
					normalCnt++;
				}
			}
		}

		// 색약 o
		visited = new boolean[N][N];
		int blindCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 'G') {
					grid[i][j] = 'R';

					}
				
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if (visited[i][j] == false && grid[i][j] == 'R') {
					dfs(i, j, 'R');
					blindCnt++;
				}
			
				else if (visited[i][j] == false && grid[i][j] == 'B') {
					dfs(i, j, 'B');
					blindCnt++;
				}
			}
		}
		System.out.println(normalCnt + " " + blindCnt);
	}
	
	private static void dfs(int x, int y, char c) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				continue;
			}
			if (visited[nx][ny] == false && grid[nx][ny] == c) {
				dfs(nx, ny, c);
			}
		}
	}
}