import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2436 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int gcd = Integer.parseInt(st.nextToken());
		int lcm = Integer.parseInt(st.nextToken());

		int minSum = Integer.MAX_VALUE;
		int target = lcm / gcd;
		int resA = 0;
		int resB = 0;

		for (int i = 1; i * i <= target; i++) {
			if (target % i == 0) {
				int a = i;
				int b = target / i;

				if (getGCD(a, b) == 1) {
					if (minSum > a + b) {
						minSum = a + b;
						resA = a * gcd;
						resB = b * gcd;
					}
				}
			}
		}

		System.out.println(resA + " " + resB);
	}

	public static int getGCD(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}

		return a;
	}
}