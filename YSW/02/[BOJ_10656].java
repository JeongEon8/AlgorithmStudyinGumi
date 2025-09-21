import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10656 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strArr = br.readLine().split(" ");
		int N = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);
		String[][] puzzle = new String[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			strArr = br.readLine().split("");
			for (int j = 1; j < M + 1; j++) {
				puzzle[i][j] = strArr[j - 1];
			}
		}

		int count = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				// 가로
				if (puzzle[i][j].equals(".") && j + 2 <= M && !puzzle[i][j + 1].equals("#")
						&& !puzzle[i][j + 2].equals("#")) {
					if (j == 1 || puzzle[i][j - 1].equals("#")) {
						puzzle[i][j] = "" + count++;
					}
				}

				// 세로
				if (puzzle[i][j].equals(".") && i + 2 <= N && !puzzle[i + 1][j].equals("#")
						&& !puzzle[i + 2][j].equals("#")) {
					if (i == 1 || puzzle[i - 1][j].equals("#")) {
						puzzle[i][j] = "" + count++;
					}
				}
			}
		}
		sb.append(--count + "\n");

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (!puzzle[i][j].equals(".") && !puzzle[i][j].equals("#")) {
					sb.append(i + " ").append(j + "\n");
				}
			}
		}

		System.out.println(sb.toString());
	}
}