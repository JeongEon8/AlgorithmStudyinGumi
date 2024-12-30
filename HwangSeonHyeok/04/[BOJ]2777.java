import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int div(int n) {
		for (int i = 9; i > 1; i--) {
			if (n % i == 0) {
				return n / i;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(in.readLine());
			int ans = 0;
			while (n >= 10) {
				n = div(n);
				ans++;
			}
			if (n == -1) {
				ans = -1;
			} else {
				ans++;
			}

			System.out.println(ans);

		}

	}

}