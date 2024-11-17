import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int mod = (int) 1e6;

	static long fact(long a, long b) {
		a *= b;
		while (a % 10 == 0) {
			a /= 10;
		}
		a %= mod;
		return a;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String n = in.readLine();
		int zeroCnt = 0;
		int idx = n.length() - 1;
		while (n.charAt(idx) == '0') {
			zeroCnt++;
			idx--;
		}
		int fiveN = 0;
		if (zeroCnt == 0)
			fiveN++;
		while (zeroCnt > 0) {
			fiveN += 5;
			int tmp = fiveN;
			while (tmp % 5 == 0) {
				zeroCnt--;
				tmp /= 5;
			}
		}

		long factNum = 1;
		for (int i = 2; i <= fiveN; i++) {
			factNum = fact(factNum, i);
		}
		String factNumStr = Long.toString(factNum);
		int ans = 1;
		for (int i = 1; i <= 5; i++) {
			int len = factNumStr.length() - 1;
			int tmpIdx = idx;
			int cnt = 0;
			while (len > -1 && factNumStr.charAt(len) == n.charAt(tmpIdx)) {
				cnt++;
				len--;
				tmpIdx--;

			}
			if (cnt > 4 || len == -1) {
				ans = fiveN + i - 1;
				break;
			}
			factNum = fact(factNum, fiveN + i);
			factNumStr = Long.toString(factNum);

		}
		System.out.println(ans);

	}

}