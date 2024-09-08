import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static boolean[][] dp;
	static boolean[][] visited;

	static boolean solve(int stone, int turn) {
		if (visited[stone][turn])
			return dp[stone][turn];
		visited[stone][turn] = true;
		if (stone == 0) {
			return dp[stone][turn] = false;
		}
		boolean thisTurnWin = false;
		if (stone - 1 >= 0) {
			thisTurnWin = thisTurnWin || !solve(stone - 1, (turn + 1) % 2);
		}
		if (stone - 3 >= 0) {
			thisTurnWin = thisTurnWin || !solve(stone - 3, (turn + 1) % 2);
		}

		return dp[stone][turn] = thisTurnWin;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		dp = new boolean[n + 1][2];
		visited = new boolean[n + 1][2];
		solve(n, 0);
		if (dp[n][0]) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}

	}

}