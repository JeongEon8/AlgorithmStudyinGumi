import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406 {

	static int N, M, K, ans = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] used;
	static Rotate[] rotateInfo, rotateOrder;
	static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rotateInfo = new Rotate[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			rotateInfo[i] = new Rotate(r, c, s);
		}

		// 회전 순서 고르기
		rotateOrder = new Rotate[K];
		used = new boolean[K];
		dfs(0);
		System.out.println(ans);
	}

	static void dfs(int depth) {
		// 회전 순서를 다 골랐다면 배열 회전하기
		if (depth == K) {
			ans = Math.min(ans, rotateArr());
			return;
		}

		for (int i = 0; i < K; i++) {
			if (used[i])
				continue;

			used[i] = true;
			rotateOrder[depth] = rotateInfo[i];
			dfs(depth + 1);
			used[i] = false;
		}
	}

	static int[][] copyArray(int[][] from) {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = from[i][j];
			}
		}
		return tmp;
	}

	static int rotateArr() {
		int[][] arr1 = copyArray(arr);
		int[][] arr2 = copyArray(arr);

		for (int i = 0; i < K; i++) {
			boolean[][] visited = new boolean[N][M];
			Rotate rotate = rotateOrder[i];
			int sr = rotate.r - rotate.s, sc = rotate.c - rotate.s;
			int er = rotate.r + rotate.s, ec = rotate.c + rotate.s;

			// 회전 시작점
			int r = sr, c = sc;
			int end = (er - sr) / 2;
			// (정사각형의 길이 / 2)만큼만 회전하면 됨
			for (int j = 0; j < end; j++) {
				int x = r, y = c, d = 0;
				while (true) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx < sr || ny < sc || nx > er || ny > ec || visited[nx][ny]) {
						// 범위 벗어나거나 방문한 곳이면 방향 바꾸기
						if (++d == 4)
							d = 0;
						nx = x + dx[d];
						ny = y + dy[d];
					}

					arr2[nx][ny] = arr1[x][y];
					visited[nx][ny] = true;
					x = nx;
					y = ny;

					// 시작 위치로 돌아오면 종료하기
					if (x == r && y == c)
						break;
				}
				r++;
				c++;
			}
			// 회전을 여러 번 하므로 회전한 배열을 기존 배열로 복사하기
			arr1 = copyArray(arr2);
		}

		int minSum = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			// 각 행의 합 구하기
			for (int j = 0; j < M; j++) {
				sum += arr2[i][j];
			}
			minSum = Math.min(minSum, sum);
		}
		return minSum;
	}

	static class Rotate {
		int r, c, s;

		public Rotate(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
}
