import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String s = in.readLine();
		if (n <= 25) {
			System.out.println(s);
		} else {
			boolean isSameSentence = true;
			for (int i = 11; i <= n - 13; i++) {
				if (s.charAt(i) == '.') {
					isSameSentence = false;
					break;
				}
			}
			if (isSameSentence) {
				String prefix = s.substring(0, 11);
				String suffix = s.substring(n - 11);
				System.out.println(prefix + "..." + suffix);
			} else {
				String prefix = s.substring(0, 9);
				String suffix = s.substring(n - 10);
				System.out.println(prefix + "......" + suffix);
			}
		}

	}

}