import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < t; tc++) {
			String[] split = in.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			int x = Integer.parseInt(split[2]);
			int GCD = gcd(a, b);
			sb.append(x / GCD).append('\n');
		}
		System.out.println(sb);

	}

}
