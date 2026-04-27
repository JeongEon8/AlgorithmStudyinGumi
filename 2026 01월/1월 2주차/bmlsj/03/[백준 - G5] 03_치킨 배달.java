
public class Main {

	static int N, M, V;
	static int[][] map;
	static boolean[] chooseChicken;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		V = Integer.MAX_VALUE;

		map = new int[N][N];
		List<int[]> chickens = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			split = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(split[j]);
				if (map[i][j] == 2) {
					chickens.add(new int[] { i, j });
				}
			}
		}

		chooseChicken = new boolean[chickens.size()];
		combi(0, 0, chickens);

		System.out.println(V);

	}

	static void combi(int cnt, int start, List<int[]> chickens) {

		if (cnt == M) {
			int sum = 0;
			// 집별 모든 치킨 거리(한 집에서 모든 치킨집의 최소)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) { // 집
						sum += calcDir(chickens, i, j);
					}
				}
			}
			V = Math.min(sum, V);
			return;
		}

		for (int i = start; i < chickens.size(); i++) {
			if (!chooseChicken[i]) {
				chooseChicken[i] = true;
				combi(cnt + 1, i + 1, chickens);
				chooseChicken[i] = false;
			}
		}

	}

	static int calcDir(List<int[]> chickens, int x, int y) {

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < chooseChicken.length; i++) {
			if (chooseChicken[i]) {
				int nx = Math.abs(chickens.get(i)[0] - x);
				int ny = Math.abs(chickens.get(i)[1] - y);

				min = Math.min(min, nx + ny);
			}

		}

		return min;
	}
}
