import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int currentPlayer = Integer.parseInt(in.readLine());
		int[][] board = new int[4][4];
		int ans = 0;
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			board[y][x] = currentPlayer;
			if (board[y][1] == board[y][2] && board[y][2] == board[y][3]) {
				ans = currentPlayer;
			}
			if (board[1][x] == board[2][x] && board[2][x] == board[3][x]) {
				ans = currentPlayer;
			}
			if (y == x) {
				if (board[1][1] == board[2][2] && board[2][2] == board[3][3]) {
					ans = currentPlayer;
				}
			}
			if (y + x == 4) {
				if (board[1][3] == board[2][2] && board[2][2] == board[3][1]) {
					ans = currentPlayer;
				}
			}

			if (ans != 0)
				break;
			currentPlayer = currentPlayer % 2 + 1;
		}
		System.out.println(ans);
	}

}