import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		int k = Integer.parseInt(br.readLine());

		int sx, sy, ex, ey;
		for (int i = 0; i < k; i++) {
			input = br.readLine().split(" ");
			sx = Integer.parseInt(input[0]) - 1;
			sy = Integer.parseInt(input[1]) - 1;
			ex = Integer.parseInt(input[2]) - 1;
			ey = Integer.parseInt(input[3]) - 1;

			calcSum(sx, sy, ex, ey);
		}

	}

	static void calcSum(int sx, int sy, int ex, int ey) {

		int sum = 0;

		for (int i = sx; i <= ex; i++) {
		    for (int j = sy; j <= ey; j++) {
		        sum += map[i][j];
		    }
		}

		System.out.println(sum);
	}

}