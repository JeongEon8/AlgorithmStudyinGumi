import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static String[] ans = { "Not a pangram", "Pangram!", "Double pangram!!", "Triple pangram!!!" };
	static int[] alphabet;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= n; tc++) {
			alphabet = new int[26];
			String str = in.readLine();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c >= 'a' && c <= 'z') {
					alphabet[c - 'a']++;
				} else if (c >= 'A' && c <= 'Z') {
					alphabet[c - 'A']++;
				}
			}
			int min = 3;
			for (int i = 0; i < 26; i++) {
				if (alphabet[i] < min) {
					min = alphabet[i];
				}
			}
			System.out.println("Case " + tc + ": " + ans[min]);
		}

	}

}