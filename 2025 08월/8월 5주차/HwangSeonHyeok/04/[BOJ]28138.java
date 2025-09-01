import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		long n = Long.parseLong(st.nextToken());
		long r = Long.parseLong(st.nextToken());
		long ans = 0;
		long diff = n - r;
		for (long i = 1; i * i <= diff; i++) {
			if (diff % i == 0) {
				long tmp = diff / i;
				if (i > r) {
					ans += i;
				}
				if (i != tmp) {
					if (tmp > r) {
						ans += tmp;
					}
				}
			}
		}
		System.out.println(ans);
	}

}