import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");
		int zero = 0, one = 0;
		boolean isZero = false;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (split[i].charAt(0) == '0') {
				if (!isZero) {
					isZero = true;
					ans = Math.max(ans, zero + one);
					zero = 0;
				}
				zero++;
			} else {
				if (isZero) {
					isZero = false;
					ans = Math.max(ans, zero + one);
					one = 0;
				}
				one++;
			}
		}
		ans = Math.max(ans, zero + one);
		System.out.println(ans);
	}

}
