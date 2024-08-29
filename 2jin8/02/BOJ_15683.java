import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15683 {

	static int N, M, totalCnt, ans, map[][]; // 사각지대 최소 = cctv 범위가 최대
	static ArrayList<CCTV> cctvInfo; // CCTV 위치 정보
	static CCTV[] cctvList; // CCTV 조합 결과 저장
	static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
	static int[] rotateCnt = { 0, 4, 2, 4, 4, 1 }; // 회전 가능한 횟수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		cctvInfo = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) { // 빈 공간의 수 세기
					totalCnt++;
				} else if (map[i][j] != 6) { // CCTV 위치 저장하기
					cctvInfo.add(new CCTV(i, j, map[i][j], -1));
				}
			}
		}

		ans = Integer.MAX_VALUE;
		cctvList = new CCTV[cctvInfo.size()];
		dfs(0);
		System.out.println(ans);
	}

	static void dfs(int depth) {
		// 모든 CCTV의 회전 방향을 선택한 경우
		if (depth == cctvInfo.size()) {
			ans = Math.min(ans, totalCnt - checkArea());
			return;
		}

		CCTV cctv = cctvInfo.get(depth);
		for (int i = 0; i < rotateCnt[cctv.num]; i++) { // 회전 가능한 횟수만큼 반복
			cctvList[depth] = new CCTV(cctv.x, cctv.y, cctv.num, i);
			dfs(depth + 1);
		}
	}

	static int checkArea() {
		int cnt = 0;
		int[][] tmp = copyArray(map);
		for (CCTV cctv : cctvList) {
			int dir = cctv.dir;
			switch (cctv.num) {
			case 1:
				cnt += changeMap(tmp, cctv.x, cctv.y, dir);
				break;
			case 2:
				for (int i = 0; i < 2; i++) { // 방향이 2개
					cnt += changeMap(tmp, cctv.x, cctv.y, dir);
					dir = (dir + 2) % 4;
				}
				break;
			case 3:
				for (int i = 0; i < 2; i++) { // 방향이 2개
					cnt += changeMap(tmp, cctv.x, cctv.y, dir);
					dir = (dir + 1) % 4;
				}
				break;
			case 4:
				for (int i = 0; i < 3; i++) { // 방향이 3개
					cnt += changeMap(tmp, cctv.x, cctv.y, dir);
					dir = (dir + 1) % 4;
				}
				break;
			case 5:
				for (int i = 0; i < 4; i++) { // 방향이 4개
					cnt += changeMap(tmp, cctv.x, cctv.y, dir);
					dir = (dir + 1) % 4;
				}
				break;
			}
		}
		return cnt;
	}

	static int changeMap(int[][] arr, int nx, int ny, int dir) {
		int cnt = 0;
		while (true) {
			nx += dx[dir];
			ny += dy[dir];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 6)
				break;

			if (arr[nx][ny] == 0) {
				arr[nx][ny] = -1;
				cnt++;
			}
		}
		return cnt;
	}

	static int[][] copyArray(int[][] from) {
		int[][] to = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				to[i][j] = from[i][j];
			}
		}
		return to;
	}

	static class CCTV {
		int x, y;
		int num; // CCTV 번호
		int dir; // CCTV 회전 방향

		public CCTV(int x, int y, int num, int dir) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
		}
	}
}
