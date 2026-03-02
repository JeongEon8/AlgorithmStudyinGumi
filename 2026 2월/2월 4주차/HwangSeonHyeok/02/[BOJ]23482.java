import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] matches = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6, 6 };
	static int n;

	static boolean isAns(int a, int b, int cnt) {
		int sum = a + b;
		cnt += matches[sum / 10] + matches[sum % 10];
		if (cnt == n) {
			StringBuilder sb = new StringBuilder();
			String strA = a < 10 ? "0" + Integer.toString(a) : Integer.toString(a);
			String strB = b < 10 ? "0" + Integer.toString(b) : Integer.toString(b);
			String strSum = sum < 10 ? "0" + Integer.toString(sum) : Integer.toString(sum);
			System.out.println(strA + "+" + strB + "=" + strSum);
			return true;
		}
		return false;
	}

	static boolean solve(int depth, int a, int b, int cnt) {
		if (a + b > 100) {
			return false;
		}
		if (depth == 4) {
			return isAns(a, b, cnt);
		}

		for (int i = 0; i < 10; i++) {
			if (depth < 2) {
				if (solve(depth + 1, a * 10 + i, b, cnt + matches[i])) {
					return true;
				}
			} else {
				if (solve(depth + 1, a, b * 10 + i, cnt + matches[i])) {
					return true;
				}
			}
		}
		return false;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		if (!solve(0, 0, 0, 4)) {
			System.out.println("impossible");
		}

	}

}