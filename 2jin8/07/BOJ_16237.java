import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16237 {

	static int N;
	static int[][] arr;
	static int[] dx = { -1, 0, 0, 1 }, dy = { 0, -1, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		StringTokenizer st = null;

		int sharkX = -1, sharkY = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					arr[i][j] = 0;
				}
			}
		}

		int sharkSize = 2; // 아기 상어의 초기 크기는 2
		int time = 0, eatCnt = 0;
		PriorityQueue<Fish> pq = new PriorityQueue<>((f1, f2) -> {
			if (f1.dist == f2.dist) { // 거리가 같은 경우
				if (f1.x == f2.x) { // x좌표가 같은 경우
					return f1.y - f2.y; // 3. y좌표 기준 오름차순 정렬
				}
				return f1.x - f2.x; // 2. x좌표 기준 오름차순 정렬
			}
			return f1.dist - f2.dist; // 1. 거리 기준 오름차순 정렬
		});
		while (true) {
			boolean eatFish = false;
			boolean[][] visited = new boolean[N][N];
			pq.clear();

			pq.offer(new Fish(sharkX, sharkY, 0));
			visited[sharkX][sharkY] = true;

			while (!pq.isEmpty()) {
				Fish fish = pq.poll();
				int x = fish.x, y = fish.y;
				// 먹을 수 있는 물고기인지 확인하기
				if (arr[x][y] != 0 && arr[x][y] < sharkSize) {
					time += fish.dist; // 물고기를 잡아먹을 수 있는 시간 계산
					arr[x][y] = 0; // 물고기 없어진 것 표시
					eatCnt++; // 먹은 물고기의 수 증가
					eatFish = true; // 물고기 먹었다고 표시
					sharkX = x; // 상어 위치 이동
					sharkY = y;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;

					// 이미 방문했거나 물고기 크기가 상어 크기보다 크다면 이동 불가
					if (visited[nx][ny] || arr[nx][ny] > sharkSize)
						continue;

					pq.offer(new Fish(nx, ny, fish.dist + 1));
					visited[nx][ny] = true;
				}
			}

			// 더 이상 먹을 물고기가 없으면 엄마 상어에게 도움 요청
			if (!eatFish) { // 물고기를 먹지 못한 경우
				break;
			}

			// 자신의 크기만큼 물고기를 먹으면 크기 1 증가
			if (eatCnt == sharkSize) {
				sharkSize++;
				eatCnt = 0;
			}
		}
		System.out.println(time);
	}

	static class Fish {
		int x, y, dist;

		public Fish(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
}
