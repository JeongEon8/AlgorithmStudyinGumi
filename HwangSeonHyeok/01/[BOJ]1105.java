import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		String start = split[0];
		String end = split[1];
		int ans = 0;
		if (start.length() == end.length()) {
			for (int i = 0; i < start.length(); i++) {
				if (start.charAt(i) != end.charAt(i)) {
					break;
				}
				if (start.charAt(i) == '8') {
					ans++;
				}
			}
		}
		System.out.println(ans);

	}

}