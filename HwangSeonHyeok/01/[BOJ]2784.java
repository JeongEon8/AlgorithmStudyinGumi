import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	static String[] words = new String[6];
	static String[] ans = new String[3];
	static String[] selectedWord = new String[3];
	static boolean findAns = false;
	static boolean[] selected = new boolean[6];

	static void solve(int depth) {
		if (depth == 3) {
			String w0 = "" + selectedWord[0].charAt(0) + selectedWord[1].charAt(0) + selectedWord[2].charAt(0);
			String w1 = "" + selectedWord[0].charAt(1) + selectedWord[1].charAt(1) + selectedWord[2].charAt(1);
			String w2 = "" + selectedWord[0].charAt(2) + selectedWord[1].charAt(2) + selectedWord[2].charAt(2);
			List<String> list = new ArrayList<>();
			list.add(selectedWord[0]);
			list.add(selectedWord[1]);
			list.add(selectedWord[2]);
			list.add(w0);
			list.add(w1);
			list.add(w2);

			Collections.sort(list);
			if (Arrays.equals(list.toArray(), words)) {
				findAns = true;
				String selectedString = selectedWord[0] + selectedWord[1] + selectedWord[2];
				String ansString = ans[0] + ans[1] + ans[2];
				if (ans[0] == null || ansString.compareTo(selectedString) > 0) {
					ans[0] = selectedWord[0];
					ans[1] = selectedWord[1];
					ans[2] = selectedWord[2];
				}
			}
			return;
		}
		for (int i = 0; i < 6; i++) {
			if (!selected[i]) {
				selected[i] = true;
				selectedWord[depth] = words[i];
				solve(depth + 1);
				selected[i] = false;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 6; i++) {
			words[i] = in.readLine();
		}
		solve(0);
		if (findAns) {
			for (String w : ans) {
				System.out.println(w);
			}
		} else {
			System.out.println("0");
		}

	}

}