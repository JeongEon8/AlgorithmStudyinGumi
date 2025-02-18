import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int ans = 0;
		int tmp = 1;
		int cnt = 1;
		while (n >= tmp) {
			ans += ((Math.min(n, tmp * 10 - 1)) - tmp + 1) * cnt;
			tmp *= 10;
			cnt++;
		}
		System.out.println(ans);

	}

}