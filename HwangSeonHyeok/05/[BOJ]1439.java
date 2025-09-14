import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] s = in.readLine().toCharArray();
		int cnt = 1;
		for (int i = 1; i < s.length; i++) {
			if (s[i - 1] != s[i]) {
				cnt++;
			}
		}
		int ans = cnt / 2;
		System.out.println(ans);

	}

}