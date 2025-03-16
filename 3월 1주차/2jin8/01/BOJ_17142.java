import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17142 {

	static final int INF = Integer.MAX_VALUE;
	static int N, M, emptyCount, minTime;
	static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
	static int[][] map;
	static Pos[] activeVirusList;
	static ArrayList<Pos> virusList = new ArrayList<>();
	static Queue<Pos> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 바이러스의 개수
		map = new int[N][N];
		activeVirusList = new Pos[M];
		minTime = INF;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					emptyCount++; // 빈 칸의 개수 세기
				} else if (map[i][j] == 2) {
					virusList.add(new Pos(i, j));
				}
			}
		}
		choiceActiveVirus(0, 0);
		System.out.println(minTime == INF ? -1 : minTime);
	}

	// 비활성 바이러스 중 M개를 선택해서 활성화 해야 함
	static void choiceActiveVirus(int depth, int start) {
		// 순서 상관 X => 조합
		if (depth == M) {
			minTime = Math.min(minTime, bfs());
			return;
		}

		for (int i = start; i < virusList.size(); i++) {
			activeVirusList[depth] = virusList.get(i);

			choiceActiveVirus(depth + 1, i + 1);
		}
	}

	// 모든 빈 칸에 바이러스를 퍼뜨리는 최소 시간 구하기
	static int bfs() {
		boolean[][] visited = new boolean[N][N];
		// 활성 바이러스 큐에 넣기
		queue.clear();
		for (Pos activeVirus : activeVirusList) {
			queue.offer(activeVirus);
			visited[activeVirus.x][activeVirus.y] = true;
		}

		int time = 0, fullCount = 0; // 빈 칸을 채운 횟수 세기
		while (!queue.isEmpty()) {
			if (emptyCount == fullCount)
				return time;

			time++;
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Pos now = queue.poll();

				for (int i = 0; i < 4; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;

					// 이미 방문했거나 벽인 경우
					if (visited[nx][ny] || map[nx][ny] == 1)
						continue;

					// 빈 칸일 경우에만 세기
					if (map[nx][ny] == 0)
						fullCount++;

					queue.offer(new Pos(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		return INF;
	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
