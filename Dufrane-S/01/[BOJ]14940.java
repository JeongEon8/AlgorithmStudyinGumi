import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] dy = { 0, 0, 1, -1 };
		int[] dx = { 1, -1, 0, 0 };
		int n, m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] box = new int[n][m];
		boolean[][] done = new boolean[n][m];
		int sy = 1;
		int sx = 1;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				box[i][j] = tmp;
				if (tmp == 2) {
					sy = i;
					sx = j;
					box[i][j] = 0;
				}
			}
		}

		Queue<Dot> q = new ArrayDeque<>();

		q.add(new Dot(sy, sx));
		done[sy][sx] = true;
		while (!q.isEmpty()) {
			Dot now = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				if (ny < 0 || nx < 0 || ny == n || nx == m || done[ny][nx] || box[ny][nx] == 0)
					continue;
				done[ny][nx] = true;
				Dot ndot = new Dot(ny, nx);
				q.add(ndot);
				box[ny][nx] = box[now.y][now.x] + 1;
			}
		}


		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(done[i][j]==false && box[i][j]==1) {
					box[i][j]=-1;
				}
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				bw.write(Integer.toString(box[i][j]));
				bw.write(' ');
			}
			bw.write('\n');
		}
		bw.flush();
		bw.close();
	}
}

class Dot {
	int y;
	int x;

	Dot(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
