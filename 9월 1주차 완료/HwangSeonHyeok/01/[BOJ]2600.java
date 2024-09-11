import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static class State {
		int a, b;
		boolean turn;// 0은 A, ,B는 1

		public State(int a, int b, boolean turn) {
			super();
			this.a = a;
			this.b = b;
			this.turn = turn;
		}
	}

	static int[] bArray;
	static boolean[][][] dp;
	static boolean[][][] visited;

	static boolean solve(int a, int b, int turn) {
		if (visited[a][b][turn]) {
			return dp[a][b][turn];
		}
		visited[a][b][turn] = true;
		
		if (turn == 1) {
			if (a == 0 && b == 0) {
				// 0 0에서 b차례면 a가 이길 수 있다.
				return dp[a][b][1] = true;
			} else {
				//b차례면 패배하는 경우가 있다면 거기로
				boolean current = true;
				for (int i = 0; i < 3; i++) {
					int tmp = a - bArray[i];
					if (tmp >= 0) {
						current = current && solve(tmp, b, 0);
					}
					tmp = b - bArray[i];
					if (tmp >= 0) {
						current = current && solve(a, tmp, 0);
					}
				}
				return dp[a][b][turn] = current;
			}
		} else {
			if (a == 0 && b == 0) {
				return dp[a][b][0] = false;
			} else {
				boolean current = false;
				for (int i = 0; i < 3; i++) {
					int tmp = a - bArray[i];
					if (tmp >= 0) {
						current = current || solve(tmp, b, 1);
					}
					tmp = b - bArray[i];
					if (tmp >= 0) {
						current = current || solve(a, tmp, 1);
					}
				}
				return dp[a][b][turn] = current;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		dp = new boolean[501][501][2];
		visited = new boolean[501][501][2];
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		bArray = new int[3];
		for (int i = 0; i < 3; i++) {
			bArray[i] = Integer.parseInt(split[i]);
		}
		for (int i = 0; i < 5; i++) {
			split = in.readLine().split(" ");
			int k1 = Integer.parseInt(split[0]);
			int k2 = Integer.parseInt(split[1]);
			boolean ans = solve(k1,k2,0);
			if (ans) {
				System.out.println("A");
			} else {
				System.out.println("B");
			}
		}

	}

}