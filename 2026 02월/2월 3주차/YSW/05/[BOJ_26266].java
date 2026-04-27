import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_26266 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s1.length(); i++) {
			if (s2.charAt(i) > s1.charAt(i)) {
				sb.append((char) (s2.charAt(i) - s1.charAt(i) + 'A' - 1));
			} else {
				sb.append((char) (s2.charAt(i) - s1.charAt(i) + 'A' - 1 + 26));
			}
		}

		String key = sb.toString();

		for (int i = 1; i <= key.length() / 2; i++) {
			if (key.length() % i == 0) {
				String sub = key.substring(0, i);
				sb = new StringBuilder();

				for (int j = 0; j < key.length() / i; j++) {
					sb.append(sub);
				}

				if (sb.toString().equals(key)) {
					System.out.println(sub);
					return;
				}
			}
		}

		System.out.println(key);
	}
}