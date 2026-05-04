import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static boolean visited[][];
	static int k, c, r;
	static int dx[] = { 0, 1, 0, -1 };// 상우하좌
	static int dy[] = { -1, 0, 1, 0 };
	static int cnt = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		visited = new boolean[r][c];
		k = Integer.parseInt(br.readLine());

		int y = r - 1;
		int x = 0;
		int dir = 0; // 상
		visited[y][x] = true;
		
		if (r * c < k) {
			System.out.println(0);
		} else {
			while (true) {
				if (cnt == k) {
					break;
				}
				
				int ny = y + dy[dir];
				int nx = x + dx[dir];
	
				if (ny < 0 || nx < 0 || ny >= r || nx >= c || visited[ny][nx]) {
					dir = (dir + 1) % 4;
				} else {
					visited[ny][nx] = true;
					cnt++;
					y = ny;
					x = nx;
				}
			}
			System.out.println((x + 1) + " " + (r - y));
		}

	}
	

}