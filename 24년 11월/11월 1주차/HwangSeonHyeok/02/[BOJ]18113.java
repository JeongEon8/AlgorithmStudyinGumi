import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String bit = in.readLine();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (bit.charAt(i) - '0' == 1) {
				ans++;
			}
		}
		System.out.println(ans);

	}

}