import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499 {

	static int N, M, x, y, K;
	static int[] dice, map[];
	static int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 }; // 좌우상하

	// 주사위가 이동했을 때마다 상단에 쓰여있는 값 구하기
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dice = new int[7];
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			int cmd = Integer.parseInt(st.nextToken());
			int nx = x + dx[cmd - 1];
			int ny = y + dy[cmd - 1];
			// 범위를 벗어나면 이동시키지 않음
			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			
			int down = dice[6];
			switch (cmd) {
			case 1: // 오른쪽
				dice[6] = dice[3];
				dice[3] = dice[1];
				dice[1] = dice[4];
				dice[4] = down;
				break;
			case 2: // 왼쪽
				dice[6] = dice[4];
				dice[4] = dice[1];
				dice[1] = dice[3];
				dice[3] = down;
				break;
			case 3: // 위
				dice[6] = dice[5];
				dice[5] = dice[1];
				dice[1] = dice[2];
				dice[2] = down;
				break;
			case 4: // 아래
				dice[6] = dice[2];
				dice[2] = dice[1];
				dice[1] = dice[5];
				dice[5] = down;
				break;
			}
			sb.append(dice[1]).append("\n");

			// 칸에 적힌 수가 0인 경우, 주사위의 바닥면에 쓰여있는 수가 칸에 복사됨
			if (map[nx][ny] == 0) {
				map[nx][ny] = dice[6];
			}
			// 칸에 적힌 수가 0이 아닌 경우, 칸에 적혀있는 수가 주사위의 바닥면으로 복사 & 칸에 쓰여있는 수는 0이 됨
			else {
				dice[6] = map[nx][ny];
				map[nx][ny] = 0;
			}
			x = nx;
			y = ny;
		}
		System.out.println(sb);
	}
}
