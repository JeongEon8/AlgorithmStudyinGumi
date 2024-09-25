import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17135 {

	static int N, M, D, enemy, ans;
	static int[] pos = new int[3]; // 궁수의 위치를 저장할 배열
	static int[][] map;

	static int[] dx = { 0, -1, 0 }, dy = { -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken()); // 궁수의 공격 거리 제한
		map = new int[N + 1][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					enemy++;
			}
		}
		dfs(0, 0);
		System.out.println(ans);
	}

	static void dfs(int depth, int start) {
		// 3명의 궁수 위치를 결정한 경우
		if (depth == 3) {
			ans = Math.max(ans, bfs());
			return;
		}

		for (int i = start; i < M; i++) {
			pos[depth] = i;
			dfs(depth + 1, i + 1);
		}
	}

	static int[][] copyArr() {
		int[][] arr = new int[N + 1][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = map[i][j];
			}
		}
		return arr;
	}

	static int bfs() {
		int removeCnt = 0;
		int tmpEnemy = enemy;

		Queue<Pos> queue = new ArrayDeque<>();
		int[][] tmpMap = copyArr();
		while (tmpEnemy != 0) {
			Pos[] removeArr = new Pos[3];
			for (int i = 0; i < 3; i++) {
				boolean[][] visited = new boolean[N + 1][M];
				queue.clear();

				int x = N, y = pos[i];
				queue.offer(new Pos(x, y));
				visited[x][y] = true;

				while (!queue.isEmpty()) {
					Pos now = queue.poll();
					// 적이 있는 위치라면 기록하고 탐색 종료하기
					if (tmpMap[now.x][now.y] == 1) {
						removeArr[i] = now;
						break;
					}

					for (int j = 0; j < 3; j++) {
						int nx = now.x + dx[j];
						int ny = now.y + dy[j];
						if (nx < 0 || ny < 0 || nx >= N || ny >= M)
							continue;

						int d = Math.abs(x - nx) + Math.abs(y - ny);
						if (visited[nx][ny] || d > D)
							continue;

						queue.offer(new Pos(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}

			for (Pos p : removeArr) {
				if (p == null || tmpMap[p.x][p.y] == 0)
					continue;

				// 공격받은 적은 게임에서 제외됨
				tmpMap[p.x][p.y] = 0;
				tmpEnemy--; // 남아있는 적의 수 감소
				removeCnt++; // 제거할 수 있는 적의 수 증가
			}

			// 적이 성이 있는 칸으로 이동하면 게임에서 제외됨
			for (int i = 0; i < M; i++) {
				if (tmpMap[N - 1][i] == 1)
					tmpEnemy--;
			}

			// 궁수의 공격이 끝나면 적은 아래로 한 칸 이동함
			for (int i = N - 1; i > 0; i--) {
				tmpMap[i] = tmpMap[i - 1].clone();
			}
			Arrays.fill(tmpMap[0], 0);
		}
		return removeCnt;
	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
