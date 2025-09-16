import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9715 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < T; testCase++) {
			String[] strArr = br.readLine().split(" ");
			int row = Integer.parseInt(strArr[0]);
			int col = Integer.parseInt(strArr[1]);
			int[][] ground = new int[row][col];
			int result = 0;

			for (int i = 0; i < row; i++) {
				strArr = br.readLine().split("");
				for (int j = 0; j < col; j++) {
					ground[i][j] = Integer.parseInt(strArr[j]);
					if (ground[i][j] != 0) {
						result += 2;
					}
				}
			}

			// 상
			for (int i = 0; i < col; i++) {
				int before = 0;
				for (int j = 0; j < row; j++) {
					int area = ground[j][i] - before;
					if (area > 0) {
						result += area;
					}
					before = ground[j][i];
				}
			}

			// 하
			for (int i = 0; i < col; i++) {
				int before = 0;
				for (int j = row - 1; j >= 0; j--) {
					int area = ground[j][i] - before;
					if (area > 0) {
						result += area;
					}
					before = ground[j][i];
				}
			}

			// 좌
			for (int i = 0; i < row; i++) {
				int before = 0;
				for (int j = 0; j < col; j++) {
					int area = ground[i][j] - before;
					if (area > 0) {
						result += area;
					}
					before = ground[i][j];
				}
			}

			// 우
			for (int i = 0; i < row; i++) {
				int before = 0;
				for (int j = col - 1; j >= 0; j--) {
					int area = ground[i][j] - before;
					if (area > 0) {
						result += area;
					}
					before = ground[i][j];
				}
			}
			
			System.out.println(result);
		}
	}
}