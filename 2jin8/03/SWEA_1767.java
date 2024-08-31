import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1767 {

	static int N, maxCore, minLen, map[][];
	static ArrayList<Point> coreList = new ArrayList<>();
	static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			coreList.clear();
			maxCore = 0;
			minLen = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						coreList.add(new Point(i, j));
					}
				}
			}
			dfs(0, 0, 0);
			sb.append("#").append(t).append(" ").append(minLen).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int depth, int core, int len) {
		// 남은 코어의 개수를 다 연결해도 최대 코어 개수보다 작으면 더 이상 연결할 필요가 없음..!
		// 남은 코어의 개수: coreList.size() - depth
		// 현재까지 연결한 코어의 개수: core
		if (coreList.size() - depth + core < maxCore)
			return;

		if (depth == coreList.size()) {
			if (maxCore < core) {
				maxCore = core;
				minLen = len; // 길이도 갱신해야 함..! 
			} else if (maxCore == core) { // 코어 개수가 같을 때도 고려해야 함..!
				minLen = Math.min(minLen, len);
			}
			return;
		}

		Point point = coreList.get(depth);
		int x = point.x, y = point.y;
		// 가장자리에 위치한 core는 이미 전원이 연결되므로 다음 core로 넘어가기
		if (x == 0 || x == N - 1 || y == 0 || y == N - 1) {
			dfs(depth + 1, core + 1, len);
			return;
		}

		// 네 방향 탐색 (해당 core 선택)
		for (int i = 0; i < 4; i++) {
			// 해당 방향으로 전선을 놓을 수 있는 경우
			if (check(x, y, i)) {
				// 값 변경 & 재귀
				int nowCnt = changeArray(x, y, i, 2);

				dfs(depth + 1, core + 1, len + nowCnt);
				changeArray(x, y, i, 0); // 검사해서 옆이 다 0이였으니까 0으로 초기화해도 되는 것..
			}
		}

		// 해당 core 선택 X
		dfs(depth + 1, core, len);
	}

	// 배열 변경
	static int changeArray(int x, int y, int d, int value) {
		int nx = x, ny = y, cnt = 0;
		while (true) {
			nx += dx[d];
			ny += dy[d];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				break;

			cnt++;
			map[nx][ny] = value;
		}
		return cnt;
	}

	// 놓을 수 있는지 확인
	static boolean check(int x, int y, int d) {
		int nx = x, ny = y;
		while (true) {
			nx += dx[d];
			ny += dy[d];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				break;

			if (map[nx][ny] != 0)
				return false;
		}
		return true;
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
