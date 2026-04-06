import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		int[] alphCount = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char alph = s.charAt(i);
			alphCount[alph - 'A']++;
		}
		int oddCount = 0;
		int oddIndex = -1;
		for (int i = 0; i < 26; i++) {
			if (alphCount[i] % 2 == 1) {
				oddCount++;
				oddIndex = i;
			}
		}
		if (oddCount > 1) {
			System.out.println("I'm Sorry Hansoo");
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < alphCount[i] / 2; j++) {
					sb.append((char) ('A' + i));
				}
			}
			String end = sb.reverse().toString();
			sb.reverse();
			if (oddIndex != -1)
				sb.append((char) ('A' + oddIndex));
			sb.append(end);
			System.out.println(sb);
		}

	}

}