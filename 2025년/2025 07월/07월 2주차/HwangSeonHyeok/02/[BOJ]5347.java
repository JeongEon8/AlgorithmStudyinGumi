import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(in.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long ans = a * b / gcd(a, b);
			sb.append(ans).append("\n");
		}
		System.out.println(sb);

	}

}