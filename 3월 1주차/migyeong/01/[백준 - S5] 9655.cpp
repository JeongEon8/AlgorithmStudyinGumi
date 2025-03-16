import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int map[][];
	static int result;

	// 오른쪽, 아래, 오른쪽 아래 대각선
	static int dx[] = { 0, 1, 1 };
	static int dy[] = { 1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		result = 0;

		// 파이프를 처음에 가로로 놓고 시작
		dfs(0, 1, 2); // 2는 가로 상태

		System.out.println(result);
	}

	private static void dfs(int x, int y, int type) {

		// 종료 조건: (N-1, N-1) 도착 시 결과값 증가
		if (x == N - 1 && y == N - 1) {
			result++;
			return;
		}

		// 3가지 이동 방향에 대해 검사
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0) {
				// 가로 파이프일 때는 세로로 이동 불가
				if (type == 2 && i == 1)
					continue;
				// 세로 파이프일 때는 가로로 이동 불가
				if (type == 3 && i == 0)
					continue;

				// 대각선으로 이동할 때는 세 칸이 모두 비어 있어야 함
				if (i == 2 && (map[x + 1][y] != 0 || map[x][y + 1] != 0))
					continue;

				// 다음 상태로 재귀 호출
				dfs(nx, ny, i + 2); // i + 2는 파이프의 새로운 상태를 의미
			}
		}
	}
}
