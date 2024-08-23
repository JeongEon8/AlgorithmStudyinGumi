import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_5644 {

	static int N = 10, M, A, total;
	static int[] moveA, moveB;
	static int[] dx = { 0, -1, 0, 1, 0 }, dy = { 0, 0, 1, 0, -1 };
	static Battery[] batteries;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			batteries = new Battery[A];

			// 이동 정보 저장하기
			moveA = new int[M + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}

			moveB = new int[M + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			// 배터리 정보
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				batteries[i] = new Battery(new Point(x, y), c, p);
			}
			charging();
			sb.append("#").append(t).append(" ").append(total).append("\n");
		}
		System.out.println(sb);
	}

	static void charging() {
		Point userA = new Point(1, 1);
		Point userB = new Point(10, 10);
		total = 0; // 충전한 양의 최댓값

		// 접속할 수 있는 배터리 정보
		ArrayList<Integer> bA = new ArrayList<>();
		ArrayList<Integer> bB = new ArrayList<>();

		// 0초부터 충전 가능
		for (int i = 0; i <= M; i++) {
			// A, B 이동하기
			userA.move(moveA[i]);
			userB.move(moveB[i]);

			// 충전 영역에 들어가는지 확인하기
			bA.clear();
			bB.clear();

			for (int j = 0; j < A; j++) {
				Battery battery = batteries[j];
				// A 확인
				if (Math.abs(battery.point.x - userA.x) + Math.abs(battery.point.y - userA.y) <= battery.c) {
					bA.add(j); // 충전 범위 안에 들어가면 저장하기
				}
				// B 확인
				if (Math.abs(battery.point.x - userB.x) + Math.abs(battery.point.y - userB.y) <= battery.c) {
					bB.add(j);
				}
			}

			// A만 충전 영역에 들어간 경우
			int max = 0;
			if (bA.size() != 0 && bB.size() == 0) {
				max = batteries[bA.get(0)].p;
				for (int k = 1; k < bA.size(); k++) {
					max = Math.max(max, batteries[bA.get(k)].p);
				}
				total += max;
			}
			// B만 충전 영역에 들어간 경우
			else if (bA.size() == 0 && bB.size() != 0) {
				max = batteries[bB.get(0)].p;
				for (int k = 1; k < bB.size(); k++) {
					max = Math.max(max, batteries[bB.get(k)].p);
				}
				total += max;
			}
			// A와 B 모두 충전 영역에 들어간 경우
			else if (bA.size() != 0 && bB.size() != 0) {
				max = 0;
				// 하나씩 비교해서 최대 충전량 구하기
				for (int k = 0; k < bA.size(); k++) {
					for (int l = 0; l < bB.size(); l++) {
						// A와 B가 동일한 충전 영역에 들어간 경우
						if (bA.get(k) == bB.get(l)) {
							max = Math.max(max, batteries[bA.get(k)].p); // 하나의 배터리 성능을 더하기 (각자 나눠 가지므로.. p/2 + p/2 = p)
						}
						// A와 B가 다른 충전 영역에 들어간 경우
						else {
							max = Math.max(max, batteries[bA.get(k)].p + batteries[bB.get(l)].p); // 각 배터리의 성능을 더하기
						}
					}
				}
				total += max; // 최대 충전량 더하기
			}
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void move(int d) {
			this.x += dx[d];
			this.y += dy[d];
		}
	}

	static class Battery {
		Point point;
		int c; // 충전 범위
		int p; // 성능

		public Battery(Point point, int c, int p) {
			this.point = point;
			this.c = c;
			this.p = p;
		}
	}
}
