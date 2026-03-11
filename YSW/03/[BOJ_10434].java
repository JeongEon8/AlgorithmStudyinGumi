import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_10434 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int testnum = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			sb.append(testnum).append(" ").append(m).append(" ");

			if (!isPrimeNumber(m)) {
				sb.append("NO").append("\n");
				continue;
			}

			sb.append(isHappy(m) ? "YES" : "NO").append("\n");
		}

		System.out.println(sb);
	}

	public static boolean isPrimeNumber(int n) {
		if (n < 2)
			return false;

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	public static boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<Integer>();

		while (n != 1) {
			if (set.contains(n))
				return false;
			set.add(n);

			int sum = 0;
			while (n != 0) {
				int digit = n % 10;
				sum += digit * digit;
				n /= 10;
			}
			n = sum;
		}

		return true;
	}
}