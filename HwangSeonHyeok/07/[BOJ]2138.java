import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[] start;
	static int[] to;

	static String startStr, toStr;

	static int n;

	static void click(int idx) {
		start[idx - 1] ^= 1;
		start[idx] ^= 1;
		if (idx + 1 < n)
			start[idx + 1] ^= 1;
	}

	static int solve() {
		int result = 0;
		for (int i = 1; i < n; i++) {
			if (start[i - 1] != to[i - 1]) {
				click(i);
				result++;
			}
		}
		if (start[n - 1] == to[n - 1]) {
			return result;
		}
		return -1;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		startStr = in.readLine();
		toStr = in.readLine();
		start = new int[n];
		to = new int[n];
		for (int i = 0; i < n; i++) {
			start[i] = startStr.charAt(i) - '0';
			to[i] = toStr.charAt(i) - '0';
		}
		int result = solve();
		if (result != -1) {
			System.out.println(result);
		} else {
			for (int i = 0; i < n; i++) {
				start[i] = startStr.charAt(i) - '0';
			}
			start[0] ^= 1;
			start[1] ^= 1;
			result = solve();
			if (result != -1) {
				System.out.println(result + 1);
			} else {
				System.out.println(-1);
			}

		}

	}

}