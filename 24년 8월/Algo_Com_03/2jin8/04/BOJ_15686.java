import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {

	static final int MAX = 999_999_999;
	static int N, M, minDist; // N: N * N 크기의 도시, M: 선택할 치킨집의 최대 개수, minDist: 도시의 치킨 거리의 최솟값
	static boolean[][] check; // 치킨집 선택 여부를 저장하기 위한 배열
	static ArrayList<Point> houseList, chickenList; // 집과 치킨집의 위치 정보를 저장하기 위한 리스트

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 초기화
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		check = new boolean[N + 1][N + 1]; // (r, c) ⇒ r, c는 1부터 시작
		houseList = new ArrayList<>();
		chickenList = new ArrayList<>();
		minDist = MAX;

		// 치킨집, 집 정보 저장하기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int now = Integer.parseInt(st.nextToken());
				if (now == 1) { // 현재 위치가 집인 경우
					houseList.add(new Point(i, j));
				} else if (now == 2) { // 현재 위치가 치킨집인 경우
					chickenList.add(new Point(i, j));
				}
			}
		}

		if (chickenList.size() - M == 0) { // 폐업시키지 않을 치킨집의 개수가 치킨집의 개수와 같으면 바로 도시의 치킨 거리 구하기
			for (int i = 0; i < chickenList.size(); i++) {
				Point c = chickenList.get(i);
				check[c.x][c.y] = true;
			}
			System.out.println(getDistance());
		} else { // 그렇지 않으면 선택할 치킨집을 고른 후, 도시의 치킨 거리 구하기
			dfs(0, 0);
			System.out.println(minDist);
		}
	}

	private static void dfs(int depth, int start) {
		if (depth == M) { // M개의 치킨집을 선택한 경우
			// 도시의 치킨 거리의 최솟값 구하기
			minDist = Math.min(minDist, getDistance());
			return;
		}

		for (int i = start; i < chickenList.size(); i++) {
			Point p = chickenList.get(i);
			if (!check[p.x][p.y]) { // 현재 치킨집을 선택하지 않은 경우
				check[p.x][p.y] = true; // 치킨집 선택하기
				dfs(depth + 1, i + 1); // 다음으로 취소할 치킨집 선택하기
				check[p.x][p.y] = false; // 치킨집 선택 취소하기
			}
		}
	}

	private static int getDistance() {
		// 도시의 치킨 거리의 합
		int totalDist = 0;
		for (int i = 0; i < houseList.size(); i++) {
			Point h = houseList.get(i);
			int dist = MAX; // 현재 집의 최소 치킨 거리
			for (int j = 0; j < chickenList.size(); j++) {
				Point c = chickenList.get(j);
				if (check[c.x][c.y]) { // 해당 치킨집을 폐업하지 않으면
					// 거리 계산하기
					dist = Math.min(dist, (int) (Math.abs(c.x - h.x) + Math.abs(c.y - h.y)));
				}
			}
			totalDist += dist;

			// 현재까지의 계산한 도시의 치킨 거리 최솟값보다 크면 정답이 아니므로, 최댓값을 리턴하기
			if (totalDist >= minDist)
				return MAX;
		}
		return totalDist;
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
