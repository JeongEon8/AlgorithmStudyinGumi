import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int T, M;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String[] split = br.readLine().split(" ");
			int x1 = Integer.parseInt(split[0]);
			int y1 = Integer.parseInt(split[1]);
			int r1 = Integer.parseInt(split[2]);
			int x2 = Integer.parseInt(split[3]);
			int y2 = Integer.parseInt(split[4]);
			int r2 = Integer.parseInt(split[5]);

			dir(x1, y1, r1, x2, y2, r2);
		}

	}

	static void dir(int x1, int y1, int r1, int x2, int y2, int r2) {

		long dx = x1 - x2;
		long dy = y1 - y2;
		long d = dx * dx + dy * dy; // 거리의 제곱

		long sum = (long) (r1 + r2) * (r1 + r2);
		long diff = (long) (r1 - r2) * (r1 - r2);

		if (d == 0 && r1 == r2) {
			System.out.println(-1);
		} else if (d > sum || d < diff) {
			System.out.println(0);
		} else if (d == sum || d == diff) {
			System.out.println(1);
		} else {
			System.out.println(2);
		}
	}

}
