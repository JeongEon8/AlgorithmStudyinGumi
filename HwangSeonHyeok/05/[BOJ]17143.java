import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] dy = { 0, -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 0, 1, -1 };
	static Shark[][] map;
	static Shark[][] newMap;
	// static Shark[] sharks;
	static int r, c, m;

	static class Shark {
		int s, d, z;

		public Shark(int s, int d, int z) {
			super();
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "sh " + z;
		}
	}

	static void moveShark(int i, int j, Shark s) {
		int nextY = i + dy[s.d] * s.s;
		int nextX = j + dx[s.d] * s.s;
		int nextDir = s.d;
		if (nextY > r) {
			nextY = r - (nextY - r);
			nextDir = 1;
			if (nextY < 1) {
				nextY = 1 + (1 - nextY);
				nextDir = 2;
			}
		} else if (nextY < 1) {
			nextY = 1 + (1 - nextY);
			nextDir = 2;
			if (nextY > r) {
				nextY = r - (nextY - r);
				nextDir = 1;

			}
		} else if (nextX > c) {
			nextX = c - (nextX - c);
			nextDir = 4;
			if (nextX < 1) {
				nextX = 1 + (1 - nextX);
				nextDir = 3;
			}
		} else if (nextX < 1) {
			nextX = 1 + (1 - nextX);
			nextDir = 3;
			if (nextX > c) {
				nextX = c - (nextX - c);
				nextDir = 4;
			}
		}
		if (newMap[nextY][nextX] == null || newMap[nextY][nextX].z < s.z) {
			newMap[nextY][nextX] = new Shark(s.s, nextDir, s.z);
		}

	}

	static void fishing(int step, int sum) {
		if (step == c + 1) {
			System.out.println(sum);
			return;
		}
		int newSum = sum;
		for (int i = 1; i <= r; i++) {
			if (map[i][step] != null) {
				newSum += map[i][step].z;
				map[i][step] = null;
				break;
			}
		}
		newMap = new Shark[r + 1][c + 1];
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				Shark s = map[i][j];
				if (s != null) {
					moveShark(i, j, s);
				}
			}
		}
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				map[i][j] = newMap[i][j];
			}
		}

		fishing(step + 1, newSum);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		r = Integer.parseInt(split[0]);
		c = Integer.parseInt(split[1]);
		m = Integer.parseInt(split[2]);
		map = new Shark[r + 1][c + 1];
		// sharks = new Shark[m];
		for (int i = 0; i < m; i++) {
			split = in.readLine().split(" ");
			int sharkr = Integer.parseInt(split[0]);
			int sharkc = Integer.parseInt(split[1]);
			int s = Integer.parseInt(split[2]);
			int d = Integer.parseInt(split[3]);
			int z = Integer.parseInt(split[4]);
			if (d <= 2) {
				if (r == 1) {
					s = 0;
				} else {
					s %= (r * 2 - 2);
				}
			} else {
				if (c == 1) {
					s = 0;
				} else {
					s %= (c * 2 - 2);
				}
			}
			map[sharkr][sharkc] = new Shark(s, d, z);
		}
		fishing(1, 0);

	}

}