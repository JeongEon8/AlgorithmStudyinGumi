import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_27980 {
	public static int[][] dp;
	public static int N;
	public static int M;
	public static String board;
	public static String word;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		N = Integer.parseInt(strArr[0]);
		M = Integer.parseInt(strArr[1]);
		board = br.readLine();
		word = br.readLine();
		int result = 0;
		dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}

		for (int stratBoardIndex = 0; stratBoardIndex < N; stratBoardIndex++) {
			result = Math.max(result, check(stratBoardIndex, 0));
		}

		System.out.println(result);
	}

	public static int check(int currentBoardIndex, int currentStringIndex) {
		if (M == currentStringIndex) {
			return 0;
		}

		if (dp[currentBoardIndex][currentStringIndex] != -1) {
			return dp[currentBoardIndex][currentStringIndex];
		}

		int point = 0;

		if (currentBoardIndex > 0) {
			point = check(currentBoardIndex - 1, currentStringIndex + 1);
		}

		if (currentBoardIndex + 1 < N) {
			point = Math.max(point, check(currentBoardIndex + 1, currentStringIndex + 1));
		}

		if (board.charAt(currentBoardIndex) == word.charAt(currentStringIndex)) {
			++point;
		}

		return dp[currentBoardIndex][currentStringIndex] = point;
	}
}