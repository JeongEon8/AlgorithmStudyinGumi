import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {

	static int N, M, ans;
	static int[][] map;
	static boolean[][] visited;
	static Pos[] pos;
	static ArrayList<Pos> emptyList, virusList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		emptyList = new ArrayList<>();
		virusList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) { // 빈 칸 위치 저장
					emptyList.add(new Pos(i, j));
				} else if (map[i][j] == 2) { // 바이러스 위치 저장
					virusList.add(new Pos(i, j));
				}
			}
		}
		pos = new Pos[3];
		dfs(0, 0);
		System.out.println(ans);
	}

	static void dfs(int depth, int start) {
		// 벽을 세울 3곳을 정한 경우
		if (depth == 3) {
			// 안전 영역의 크기 구하기
			ans = Math.max(ans, bfs());
			return;
		}

		for (int i = start; i < emptyList.size(); i++) {
			Pos now = emptyList.get(i);
			pos[depth] = now;
			map[now.x][now.y] = 1; // 벽 세우기
			dfs(depth + 1, i + 1);
			map[now.x][now.y] = 0; // 벽 치우기
		}
	}

	static int bfs() {
		Queue<Pos> queue = new ArrayDeque<>();
		visited = new boolean[N][M];
		for (Pos virus : virusList) { // 바이러스 위치 저장하기
			queue.offer(virus);
			visited[virus.x][virus.y] = true;
		}

		int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
		while (!queue.isEmpty()) {
			Pos now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				// 빈 칸으로 바이러스가 퍼질 수 있을 때
				if (!visited[nx][ny] && map[nx][ny] == 0) {
					queue.offer(new Pos(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}

		// 안전 영역의 수 구하기
		int safeArea = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					safeArea++;
				}
			}
		}
		return safeArea;
	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
