import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static long solve(int num) {
		long ans = 0;
		String bin = Integer.toBinaryString(num);
		StringBuffer sb = new StringBuffer(bin);
		bin = "0" + sb.reverse().toString();

		for (int i = 1; i < bin.length(); i++) {
			if (bin.charAt(i) == '1') {
				long tmp = 2;
				for (int j = 1; j < i; j++) {
					ans += tmp * Math.pow(2, (i - j - 1));
					tmp *= 2;

				}

				ans += tmp;
			}
		}

		return ans;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		System.out.println(solve(n));

	}

}