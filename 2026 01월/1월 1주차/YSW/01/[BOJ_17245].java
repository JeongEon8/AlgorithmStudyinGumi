import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_17245 {
	public static int N;
	public static long totalComputer;
	public static int[][] rack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		rack = new int[N][N];
		totalComputer = 0;
		int maxHeight = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int number = Integer.parseInt(inputs[j]);
				rack[i][j] = number;
				totalComputer += number;
				maxHeight = Math.max(maxHeight, number);
			}
		}
		if (totalComputer == 0) {
			System.out.println(0);
		} else {
			int start = 0;
			int end = maxHeight;
			int result = Integer.MAX_VALUE;

			while (start <= end) {
				int mid = (start + end) / 2;

				if (halfCom(mid)) {
					result = mid;
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}

			System.out.println(result);
		}
	}

	private static boolean halfCom(int mid) {
		long activeCom = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				activeCom += Math.min(rack[i][j], mid);
			}
		}

		if ((totalComputer / 2) + (totalComputer % 2) <= activeCom) {
			return true;
		} else {
			return false;
		}
	}
}