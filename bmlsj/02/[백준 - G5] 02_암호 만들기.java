import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int L = Integer.parseInt(split[0]);
		int C = Integer.parseInt(split[1]);

		char[] charList = new char[C];
		split = br.readLine().split(" ");
		for (int i = 0; i < C; i++) {
			charList[i] = split[i].charAt(0);
		}

		Arrays.sort(charList);
		combi(L, C, charList, "", 0);

	}

	static void combi(int L, int C, char[] charList, String sen, int start) {

		if (sen.length() == L) {
			if (check(sen, L)) {
				System.out.println(sen);
			}
			// System.out.println(sen);
			return;
		}

		for (int i = start; i < C; i++) {
			combi(L, C, charList, sen + charList[i], i + 1);

		}
	}

	static boolean check(String sen, int L) {

		char[] senList = sen.toCharArray();
		int cnt = 0;
		for (int i = 0; i < senList.length; i++) {

			if (senList[i] == 'a' || senList[i] == 'e' || senList[i] == 'i' || senList[i] == 'o' || senList[i] == 'u') {
				cnt++;
			}
		}

		if (cnt == 0 || cnt > L - 2) {
			return false;
		}

		return true;

	}

}