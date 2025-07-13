import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(in.readLine());
		int ans = 1;
		for (int i = 1; i <= 9; i++) {
			long tmp = i;
			while (tmp <= n) {
				ans++;
				tmp = tmp * 10 + i;
			}

		}
		System.out.println(ans);
	}

}