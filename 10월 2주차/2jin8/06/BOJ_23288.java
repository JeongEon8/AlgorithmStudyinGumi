import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_23288 {

	static int N, M, K, x, y, d, score;
	static int[][] map;
	static int[] dice;
	static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 이동 방향) 0: 동, 1: 남, 2: 서, 3: 북 (시계 방향)
		dice = new int[7]; // 1: 윗 면, 6: 바닥
		for (int i = 1; i <= 6; i++) {
			dice[i] = i;
		}

		int diceX = 0, diceY = 0, diceD = 0, score = 0;
		for (int i = 0; i < K; i++) {
			// 1. 주사위 이동
			int[] moveXYD = moveDice(diceX, diceY, diceD);
			diceX = moveXYD[0];
			diceY = moveXYD[1];
			diceD = moveXYD[2];

			// 2. 점수 획득
			score += getScore(diceX, diceY);

			// 3. 이동방향 결정
			int a = dice[6], b = map[diceX][diceY];
			if (a > b) { // 시계 방향으로 회전
				diceD = (diceD + 1) % 4;
			} else if (a < b) { // 반시계 방향으로 회전
				diceD = (diceD + 3) % 4;
			}
		}
		System.out.println(score);
	}

	static int getScore(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		queue.offer(new int[] { x, y });
		visited[x][y] = true;
		int cnt = 0, num = map[x][y];
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (visited[nx][ny] || map[nx][ny] != num)
					continue;

				queue.offer(new int[] { nx, ny });
				visited[nx][ny] = true;
			}
		}
		return map[x][y] * cnt;
	}

	static int[] moveDice(int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		// 이동 방향에 칸이 없다면 이동 방향을 반대로 한 다음 한 칸 굴러가기
		if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
			d = (d + 2) % 4;
			nx = x + dx[d];
			ny = y + dy[d];
		}

		int bottom = dice[6];
		switch (d) {
		case 0: // 동
			dice[6] = dice[3];
			dice[3] = dice[1];
			dice[1] = dice[4];
			dice[4] = bottom;
			break;
		case 1: // 남
			dice[6] = dice[5];
			dice[5] = dice[1];
			dice[1] = dice[2];
			dice[2] = bottom;
			break;
		case 2: // 서
			dice[6] = dice[4];
			dice[4] = dice[1];
			dice[1] = dice[3];
			dice[3] = bottom;
			break;
		case 3: // 북
			dice[6] = dice[2];
			dice[2] = dice[1];
			dice[1] = dice[5];
			dice[5] = bottom;
			break;
		}
		return new int[] { nx, ny, d };
	}
}
