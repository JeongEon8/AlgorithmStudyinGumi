import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10830 {
	public static int N;
	public static int[][] origin;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		origin = new int[N][N];
		int[][] result = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		result = pow(origin, B);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static int[][] pow(int[][] A, long exp) {
		if (exp == 1L) {
			return A;
		}

		int[][] res = pow(A, exp / 2);
		res = multiply(res, res);

		if (exp % 2 == 1L) {
			res = multiply(res, origin);
		}

		return res;
	}

	public static int[][] multiply(int[][] m1, int[][] m2) {
		int[][] res = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
					res[i][j] %= 1000;
				}
			}
		}

		return res;
	}
}