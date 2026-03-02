package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추_1012 {
	static int M, N, K, X, Y;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {

			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[M][N];
			visited = new boolean[M][N];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				arr[X][Y] = 1;
			}
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						cnt++;

					}
				}
			}

			System.out.println(cnt);

//			for(int i = 0; i < M; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
		}

	}

	private static void dfs(int i, int j) {
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];

			if (nx >= M || ny >= N || nx < 0 || ny < 0) {
				continue;
			}
			if (arr[nx][ny] == 0)
				continue;
			if (visited[nx][ny])
				continue;

			dfs(nx, ny);

		}

	}

}
