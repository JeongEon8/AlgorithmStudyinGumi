import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_18291 {
	private static final long MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			if (N - 2 < 0) {
				if (N == 0) System.out.println(0);
				else if (N == 1) System.out.println(1);
				else System.out.println(1);
			} else {
				long result = pow(N - 2);
				System.out.println(result);
			}
		}
	}

	public static long pow(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 2 % MOD;
		}

		long half = pow(n / 2);
		long result = (half * half) % MOD;

		if (n % 2 == 1) {
			result = (result * 2) % MOD;
		}

		return result;
	}
}





