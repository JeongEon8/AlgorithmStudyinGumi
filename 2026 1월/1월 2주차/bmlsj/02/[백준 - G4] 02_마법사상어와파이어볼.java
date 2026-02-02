import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M, K;
	static List<int[]>[][] map;
	static List<int[]> fires;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		K = Integer.parseInt(split[2]);

		map = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}

		fires = new ArrayList<int[]>();
		for (int i = 0; i < M; i++) {
			split = br.readLine().split(" ");
			int[] fire = new int[5];
			for (int j = 0; j < 5; j++) {
				fire[j] = Integer.parseInt(split[j]);
			}
			fires.add(fire);
		}

		while (K > 0) {
			K--;
			move(fires);
		}

		int answer = 0;
		for (int[] f : fires) {
			// System.out.println(Arrays.toString(f));
			answer += f[2];
		}
		System.out.println(answer);
	}

	static int[] dxOdd = { -1, 0, 1, 0 }; // 상우하좌(0, 2, 4, 6)
	static int[] dyOdd = { 0, 1, 0, -1 };
	static int[] dxEven = { -1, 1, 1, -1 }; // (1, 3, 5, 7)
	static int[] dyEven = { 1, 1, -1, -1 };

	static void move(List<int[]> fires) {

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				map[i][j].clear();

		for (int i = 0; i < fires.size(); i++) {
			int r = fires.get(i)[0]; // x
			int c = fires.get(i)[1]; // y
			int m = fires.get(i)[2]; // 질량
			int s = fires.get(i)[3]; // 속력
			int d = fires.get(i)[4]; // 방향

			if (d % 2 == 0) {
				r += dxOdd[d / 2] * s % N;
				c += dyOdd[d / 2] * s % N;
			} else {
				r += dxEven[d / 2] * s % N;
				c += dyEven[d / 2] * s % N;
			}

			r = (r + N) % N;
			c = (c + N) % N;

			map[r][c].add(new int[] { r, c, m, s, d });
		}

		List<int[]> newFires = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (map[i][j].isEmpty())
					continue;

				if (map[i][j].size() == 1) {
					newFires.add(map[i][j].get(0));
				} else {
					splitFire(i, j, newFires);
				}
			}
		}

		fires.clear();
		fires.addAll(newFires);

	}

	static void splitFire(int x, int y, List<int[]> newFires) {

		int sumM = 0, sumS = 0;
		boolean odd = false, even = false;

		for (int[] f : map[x][y]) {
			sumM += f[2];
			sumS += f[3];
			if (f[4] % 2 == 0)
				even = true;
			else
				odd = true;
		}

		int m = sumM / 5;
		if (m == 0)
			return;

		int s = sumS / map[x][y].size();
		int[] dirs = (odd && even) ? new int[] { 1, 3, 5, 7 } : new int[] { 0, 2, 4, 6 };

		for (int d : dirs) {
			newFires.add(new int[] { x, y, m, s, d });
		}
	}

}