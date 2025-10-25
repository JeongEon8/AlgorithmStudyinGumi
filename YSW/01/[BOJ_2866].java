import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_2866 {
	public static int R;
	public static int C;
	public static String[] table;
	public static Set<String> wordsSet;
	public static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		R = Integer.parseInt(strArr[0]);
		C = Integer.parseInt(strArr[1]);
		table = new String[R];
		wordsSet = new HashSet<>();
		count = 0;

		for (int i = 0; i < R; i++) {
			table[i] = br.readLine();
		}

		count = search();

		System.out.println(count);
	}

	public static int search() {
		int start = 0;
		int end = R;
		while (start <= end) {
			int mid = (start + end) % 2 == 0 ? (start + end) / 2 : (start + end) / 2 + 1;

			if (check(mid)) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return start - 1;
	}

	public static boolean check(int mid) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < C; i++) {
			sb.setLength(0);
			for (int j = mid; j < R; j++) {
				sb.append(table[j].charAt(i));
			}
			if (wordsSet.contains(sb.toString())) {
				return false;
			}
			wordsSet.add(sb.toString());
		}
		return true;
	}

}
