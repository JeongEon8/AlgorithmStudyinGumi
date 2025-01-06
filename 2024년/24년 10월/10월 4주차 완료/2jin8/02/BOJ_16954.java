import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BOJ_16954 {

	static int N = 8;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 }, dy = { 0, 1, 0, -1, 1, -1, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		System.out.println(bfs());
	}

	static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { N - 1, 0 });
		visited[N - 1][0] = true;

		// 이동 순서: 캐릭터 > 벽
		while (!queue.isEmpty()) {
			// 캐릭터 이동
			int size = queue.size();
			// 시간이 흐를 때마다 초기화하기
			visited = new boolean[N][N]; // 이동하지 않고 현재 위치에 서있는 경우도 있음
			for (int s = 0; s < size; s++) {
				int[] now = queue.poll();
				if (now[0] == 0 && now[1] == N - 1) // 오른쪽 가장 윗 칸에 도착한 경우
					return 1;

				if (map[now[0]][now[1]] == '#') // 벽이 캐릭터가 있는 칸으로 이동한 경우
					continue; // 캐릭터 이동 불가

				// 8방향으로 이동하기
				for (int i = 0; i < 8; i++) {
					int nx = now[0] + dx[i];
					int ny = now[1] + dy[i];
					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;

					// 벽이 아니고 방문하지 않은 칸인 경우
					if (map[nx][ny] == '.' && !visited[nx][ny]) {
						queue.offer(new int[] { nx, ny });
						visited[nx][ny] = true;
					}
				}
				// 현재 위치에 서있기
				queue.offer(now);	
			}
			// 벽이 한 칸씩 내려감
			for (int i = N - 2; i >= 0; i--) {
				map[i + 1] = map[i].clone();
			}
			Arrays.fill(map[0], '.'); // 제일 윗 칸은 모두 빈 칸
		}
		return 0;
	}
}
