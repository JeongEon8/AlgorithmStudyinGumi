import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static class Empty {
		int y, x;

		public Empty(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

	static int[][] board = new int[9][9];
	static List<Empty> eList = new ArrayList<>();
	static boolean solved = false;
	static boolean[][][] hasNum = new boolean[3][9][10];// 0은 행 1은 열 2는 3*3

	static boolean canInsert(int y, int x, int num) {
		return !hasNum[0][y][num] && !hasNum[1][x][num] && !hasNum[2][x / 3 + (y / 3) * 3][num];
	}

	static void solve(int idx) {
		if (idx == eList.size()) {
			solved = true;
			return;
		}
		Empty c = eList.get(idx);
		for (int i = 1; i < 10; i++) {
			if (canInsert(c.y, c.x, i)) {
				hasNum[0][c.y][i] = true;
				hasNum[1][c.x][i] = true;
				hasNum[2][c.x / 3 + (c.y / 3) * 3][i] = true;
				board[c.y][c.x] = i;
				solve(idx + 1);
				if(solved)return;
				hasNum[0][c.y][i] = false;
				hasNum[1][c.x][i] = false;
				hasNum[2][c.x / 3 + (c.y / 3) * 3][i] = false;
				board[c.y][c.x] = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			String line = in.readLine();
			for (int j = 0; j < 9; j++) {
				board[i][j] = line.charAt(j) - '0';
				if (board[i][j] == 0) {
					eList.add(new Empty(i, j));
				} else {
					hasNum[0][i][board[i][j]] = true;
					hasNum[1][j][board[i][j]] = true;
					hasNum[2][(i / 3)*3 + j / 3][board[i][j]] = true;
				}
			}
		}
		solve(0);
		for(int i =0; i<9;i++) {
			for(int j = 0; j<9;j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		

	}

}