import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int[] arr = new int[26];

	static boolean solve(String str1, String str2) {
		if (str1.charAt(0) != str2.charAt(0) || str1.charAt(n - 1) != str2.charAt(n - 1)) {
			return false;
		}
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		for (int i = 0; i < n; i++) {
			char c1 = str1.charAt(i);
			char c2 = str2.charAt(i);
			if (c1 != 'a' && c1 != 'e' && c1 != 'i' && c1 != 'o' && c1 != 'u') {
				sb1.append(c1);
			}
			if (c2 != 'a' && c2 != 'e' && c2 != 'i' && c2 != 'o' && c2 != 'u') {
				sb2.append(c2);
			}
			arr[c1 - 'a']++;
			arr[c2 - 'a']--;
		}
		if (!sb1.toString().equals(sb2.toString())) {
			return false;
		}
		for (int i = 0; i < 26; i++) {
			if (arr[i] != 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		String str1 = in.readLine();
		String str2 = in.readLine();
		if (solve(str1, str2)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}