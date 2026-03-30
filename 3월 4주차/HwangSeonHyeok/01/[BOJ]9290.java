import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static boolean isWin(char[][] board, char ox) {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == ox && board[i][1] == ox && board[i][2] == ox)
				return true;
			if (board[0][i] == ox && board[1][i] == ox && board[2][i] == ox)
				return true;
		}
		if (board[0][0] == ox && board[1][1] == ox && board[2][2] == ox)
			return true;
		if (board[0][2] == ox && board[1][1] == ox && board[2][0] == ox)
			return true;

		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= t; tc++) {
			char[][] board = new char[3][3];
			for (int i = 0; i < 3; i++) {
				board[i] = in.readLine().toCharArray();
			}
			char ox = in.readLine().charAt(0);
			boolean isFinish = false;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (board[i][j] == '-') {
						board[i][j] = ox;
						if (isWin(board, ox)) {
							isFinish = true;
							break;
						}
						board[i][j] = '-';
					}
				}
				if (isFinish)
					break;
			}

			sb.append("Case ").append(tc).append(": \n");
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					sb.append(board[i][j]);
				}
				sb.append('\n');
			}
		}

		System.out.println(sb);

	}

}