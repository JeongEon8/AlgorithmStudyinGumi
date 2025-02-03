import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int N, M, x, y, K;
	static int[][] map;
	static Queue<Integer> queue = new ArrayDeque<>();

	// 동, 서, 북, 남
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	// 주사위 면 상태
	static int[] dice = new int[6]; // 0: 위, 1: 아래, 2: 앞, 3: 뒤, 4: 왼쪽, 5: 오른쪽

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		x = Integer.parseInt(split[2]);
		y = Integer.parseInt(split[3]);
		K = Integer.parseInt(split[4]);

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			split = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		split = br.readLine().split(" ");
		for (int i = 0; i < K; i++) {
			queue.offer(Integer.parseInt(split[i]));
		}

		move();
	}

	private static void move() {
		while (!queue.isEmpty()) {
			int dir = queue.poll() - 1; // 입력값이 1-based이므로 -1

			int nx = x + dx[dir];
			int ny = y + dy[dir];

			// 범위 체크
			if (!checkRange(nx, ny)) {
				continue; // 범위 벗어나면 무시
			}

			// 좌표 갱신
			x = nx;
			y = ny;

			// 주사위 회전
			rollDice(dir);

			// 지도와 주사위의 바닥면 값 처리
			if (map[x][y] == 0) {
				map[x][y] = dice[1]; // 주사위 바닥면이 복사됨
			} else {
				dice[1] = map[x][y]; // 지도의 값이 주사위 바닥면으로 복사
				map[x][y] = 0; // 지도는 0으로 변경
			}

			// 주사위 윗면 출력
			System.out.println(dice[0]);
		}
	}

	// 방향에 따른 주사위 회전
	private static void rollDice(int dir) {
		int[] temp = dice.clone();

		if (dir == 0) { // 동쪽
			dice[0] = temp[4];
			dice[1] = temp[5];
			dice[4] = temp[1];
			dice[5] = temp[0];
		} else if (dir == 1) { // 서쪽
			dice[0] = temp[5];
			dice[1] = temp[4];
			dice[4] = temp[0];
			dice[5] = temp[1];
		} else if (dir == 2) { // 북쪽
			dice[0] = temp[2];
			dice[1] = temp[3];
			dice[2] = temp[1];
			dice[3] = temp[0];
		} else if (dir == 3) { // 남쪽
			dice[0] = temp[3];
			dice[1] = temp[2];
			dice[2] = temp[0];
			dice[3] = temp[1];
		}
	}

	private static boolean checkRange(int nx, int ny) {
		return nx >= 0 && nx < N && ny >= 0 && ny < M;
	}
}
