import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_14881 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < T; testCase++) {
			String[] strArr = br.readLine().split(" ");
			int a = Integer.parseInt(strArr[0]);
			int b = Integer.parseInt(strArr[1]);
			int c = Integer.parseInt(strArr[2]);
			int max = Math.max(a, b);

			if (c > max) {
				System.out.println("NO");
				continue;
			}
			int gcd = getGCD(a, b);

			if (c % gcd == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	public static int getGCD(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
}

