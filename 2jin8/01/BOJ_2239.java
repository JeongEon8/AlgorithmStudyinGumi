import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_2239 {
	static final int N = 9;
	static boolean isFind = false;
	static int[][] arr;
	static ArrayList<Pos> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = line.charAt(j) - '0';
				if (arr[i][j] == 0)
					list.add(new Pos(i, j));
			}
		}
		dfs(0);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int depth) {
		if (isFind) { // 이미 답을 채웠다면 끝내기
			return;
		}
		
		if (depth == list.size()) { // 빈 칸을 다 채우면 탐색 종료
			isFind = true;
			return;
		}

		Pos now = list.get(depth);
		int x = now.x, y = now.y;
		for (int i = 1; i <= N; i++) {
			if (checkRow(x, i) && checkCol(y, i) && checkSquare(x, y, i)) {
				arr[x][y] = i;
				dfs(depth + 1);
				if (isFind)
					break;
				arr[x][y] = 0;
			}
		}
	}

	// 가로 확인
	static boolean checkRow(int x, int num) {
		for (int i = 0; i < N; i++) {
			if (arr[x][i] == num)
				return false;
		}
		return true;
	}

	// 세로 확인
	static boolean checkCol(int y, int num) {
		for (int i = 0; i < N; i++) {
			if (arr[i][y] == num)
				return false;
		}
		return true;
	}

	// 3 * 3 사각형 확인
	static boolean checkSquare(int x, int y, int num) {
		int sx = x / 3 * 3, sy = y / 3 * 3, ex = sx + 3, ey = sy + 3;
		for (int i = sx; i < ex; i++) {
			for (int j = sy; j < ey; j++) {
				if (arr[i][j] == num)
					return false;
			}
		}
		return true;
	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
