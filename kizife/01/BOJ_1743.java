import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K, count;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			arr[x][y] = 1;
		}
		
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j] && arr[i][j] == 1) {
					count = 0;
					dfs(i, j);
					answer = Math.max(answer, count);
				}
			}
		}
		
		System.out.println(answer);

	}

	private static void dfs(int i, int j) {
		count++;
		visited[i][j] = true;
		
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if(x < 0 || x >= N || y < 0 || y >= M || visited[x][y] || arr[x][y] == 0) continue;
			dfs(x, y);
		}
		
	}

}
