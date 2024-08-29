import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {

	static int R, C, cnt;
	static boolean find;
	static char[][] map;
	static int[] dx = { -1, 0, 1 }; // 마지막 열의 위에부터 연결되도록 방향 정하기

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		// 각 행에서 경로 찾기
		for (int i = 0; i < R; i++) {
			find = false;
			dfs(i, 0);
		}
		System.out.println(cnt);
	}

	static void dfs(int x, int y) {
		// 해당 행에서 파이프 라인 경로를 찾은 경우
		if (find) {
			return;
		}

		// 마지막 열에 도착한 경우
		if (y == C - 1) {
			cnt++;
			find = true;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + 1;
			if (nx < 0 || nx >= R || ny >= C)
				continue;

			if (map[nx][ny] == '.') {
				map[nx][ny] = 'x';
				dfs(nx, ny);
				if (find) return; // 꼭 필요함! 이게 없으면 이동할 수 있는 칸을 쓸데없이 방문 처리함
			}
		}
	}
}
