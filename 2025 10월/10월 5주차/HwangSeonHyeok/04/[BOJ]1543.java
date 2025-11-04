import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String docs = in.readLine();
		String word = in.readLine();
		int ans = 0;
		int idx = 0;
		while (idx <= docs.length() - word.length()) {
			int wordIdx = docs.indexOf(word, idx);
			if (wordIdx != -1) {
				ans++;
				idx = wordIdx + word.length();
			} else {
				break;
			}
		}
		System.out.println(ans);

	}

}