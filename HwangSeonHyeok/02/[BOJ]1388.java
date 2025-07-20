import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] tiles;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		tiles = new boolean[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String line = in.readLine();
			for (int j = 0; j < m; j++) {
				if (line.charAt(j) == '|') {
					tiles[i][j] = true;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					ans++;
					visited[i][j] = true;
					if (tiles[i][j]) {
						int y = i + 1;
						while (y < n && tiles[y][j]) {
							visited[y][j] = true;
							y++;
						}
					} else {
						int x = j + 1;
						while (x < m && !tiles[i][x]) {
							visited[i][x] = true;
							x++;
						}
					}
				}
			}
		}
		System.out.println(ans);

	}

}