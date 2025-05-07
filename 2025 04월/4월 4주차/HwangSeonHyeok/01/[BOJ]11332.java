import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static double logN(int num, int n) {
		return Math.log(num) / Math.log(n);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int c = Integer.parseInt(in.readLine());

		for (int i = 0; i < c; i++) {
			boolean isTLE = false;
			String[] split = in.readLine().split(" ");
			String bigO = split[0];
			long n = Integer.parseInt(split[1]);
			int t = Integer.parseInt(split[2]);
			int l = Integer.parseInt(split[3]);
			int max = 100000000 * l;
			if (bigO.equals("O(N)")) {
				if (n * t > max) {
					isTLE = true;
				}
			} else if (bigO.equals("O(2^N)")) {
				if (n > logN(max / t, 2)) {
					isTLE = true;
				}

			} else if (bigO.equals("O(N!)")) {
				long fact = 1L;
				for (int j = 2; j <= n; j++) {
					fact *= j;
					if (fact * t > max) {
						isTLE = true;
						break;
					}
				}

			} else if (bigO.equals("O(N^3)")) {
				if (n * n * t > max / n) {
					isTLE = true;
				}

			} else {
				if (n * n * t > max) {
					isTLE = true;
				}
			}

			if (isTLE) {
				sb.append("TLE!").append("\n");
			} else {
				sb.append("May Pass.").append("\n");
			}
		}
		System.out.println(sb);

	}

}
