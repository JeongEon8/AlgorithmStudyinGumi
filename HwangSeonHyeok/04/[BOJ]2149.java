import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static class KeyAlphabet implements Comparable<KeyAlphabet> {
		char alphabet;
		int idx;

		public KeyAlphabet(char alphabet, int idx) {
			this.alphabet = alphabet;
			this.idx = idx;
		}

		@Override
		public int compareTo(KeyAlphabet o) {
			if (this.alphabet == o.alphabet) {
				return this.idx - o.idx;
			}
			return this.alphabet - o.alphabet;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String key = in.readLine();
		int n = key.length();
		KeyAlphabet[] keyAlphabets = new KeyAlphabet[n];
		for (int i = 0; i < n; i++) {
			keyAlphabets[i] = new KeyAlphabet(key.charAt(i), i);
		}
		Arrays.sort(keyAlphabets);
		String crypt = in.readLine();
		int m = crypt.length();
		int r = m / n;
		char[][] cryptTable = new char[r][n];
		int cryptIdx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < r; j++) {
				cryptTable[j][i] = crypt.charAt(cryptIdx++);
			}
		}
		char[][] plainText = new char[r][n];
		for (int i = 0; i < n; i++) {
			int plainIdx = keyAlphabets[i].idx;
			for (int j = 0; j < r; j++) {
				plainText[j][plainIdx] = cryptTable[j][i];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r; i++) {
			sb.append(plainText[i]);
		}
		System.out.println(sb);

	}

}