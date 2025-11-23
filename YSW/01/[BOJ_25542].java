import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_25542 {
	public static int N;
	public static int L;
	public static String[] words;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		N = Integer.parseInt(strArr[0]);
		L = Integer.parseInt(strArr[1]);
		words = new String[N];

		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}

		for (int i = 0; i < N; i++) {
			String base = words[i];

			if (isValidCandidate(base)) {
				System.out.println(base);
				return;
			}

			for (int pos = 0; pos < L; pos++) {
				for (char c = 'A'; c <= 'Z'; c++) {
					if (c == base.charAt(pos)) {
						continue;
					}

					StringBuilder sb = new StringBuilder(base);
					sb.setCharAt(pos, c);
					String candidate = sb.toString();

					if (isValidCandidate(candidate)) {
						System.out.println(candidate);
						return;
					}
				}
			}
		}

		System.out.println("CALL FRIEND");
	}

	public static boolean isValidCandidate(String word) {
		for (int i = 0; i < N; i++) {
			if (hammingDistance(word, words[i]) > 1) {
				return false;
			}
		}
		return true;
	}

	public static int hammingDistance(String a, String b) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				count++;
			}
		}
		return count;
	}
}
