import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static int[][] arr, newArr;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		newArr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int minNM = Math.min(N, M) / 2;
        
		for (int i = 0; i < R; i++) {
			visited = new boolean[N][M];
			for (int j = 0; j < minNM; j++) {
				// (0, 0), (1, 1), (2, 2), .... 을 기준으로 회전하기
				rotateArr(j);
			}
			copyArr(newArr, arr);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void copyArr(int[][] from, int[][] to) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				to[i][j] = from[i][j];
			}
		}
	}

	static void rotateArr(int start) {

		int x = start, y = start, d = 0; // d: 이동 방향
		while (true) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			// 범위를 벗어나거나 이미 방문한 지점으로 이동하려는 경우, 회전 방향을 변경하기
			if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
				if (d == 3) d = 0;
				else d++;
				nx = x + dx[d];
				ny = y + dy[d];
			}

			visited[nx][ny] = true;
			newArr[nx][ny] = arr[x][y];
			x = nx;
			y = ny;

			if (x == start && y == start)
				break;
		}

	}
}
