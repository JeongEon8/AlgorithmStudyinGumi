import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static boolean[][] isBishop;
	static int n;
	static int wMax, bMax;
	static List<Empty> wList = new ArrayList<>();
	static List<Empty> bList = new ArrayList<>();

	static class Empty {
		int y, x;

		public Empty(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static boolean canBishop(int y, int x) {
		for (int i = 0; i < n; i++) {
			int x1 = x - (y - i);
			int x2 = x + (y - i);
			if (x1 >= 0 && x1 < n && isBishop[i][x1]) {
				return false;
			}
			if (x2 >= 0 && x2 < n && isBishop[i][x2]) {
				return false;
			}
		}
		return true;
	}

	static void wSolve(int idx, int cnt) {

		if (idx == wList.size()) {
			if (cnt > wMax) {
				wMax = cnt;
			}
			return;
		}
		Empty e = wList.get(idx);
		if (canBishop(e.y, e.x)) {
			isBishop[e.y][e.x] = true;
			wSolve(idx + 1, cnt + 1);
			isBishop[e.y][e.x] = false;
		}
		wSolve(idx + 1, cnt);
		return;
	}

	static void bSolve(int idx, int cnt) {

		if (idx == bList.size()) {
			if (cnt > bMax) {
				bMax = cnt;
			}
			return;
		}
		Empty e = bList.get(idx);
		if (canBishop(e.y, e.x)) {
			isBishop[e.y][e.x] = true;
			bSolve(idx + 1, cnt + 1);
			isBishop[e.y][e.x] = false;
		}
		bSolve(idx + 1, cnt);
		return;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		isBishop = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String[] split = in.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(split[j]);
				if (num == 1 && (i + j) % 2 == 0) {
					wList.add(new Empty(i, j));
				} else if (num == 1 && (i + j) % 2 == 1) {
					bList.add(new Empty(i, j));
				}
			}
		}
		wSolve(0, 0);
		bSolve(0, 0);
		System.out.println(wMax + bMax);

	}

}