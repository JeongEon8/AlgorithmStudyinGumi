import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static StringBuffer sb = new StringBuffer();
	static boolean fail = false;

	static void fillBoard(int cnt) {
		if (cnt % 2 == 1) {
			fail = true;
			return;
		}
		int A = cnt / 4;
		for (int j = 0; j < A; j++) {
			sb.append("AAAA");
		}
		if (cnt % 4 == 2) {
			sb.append("BB");
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String board = in.readLine();

		int cnt = 0;
		for (int i = 0; i < board.length(); i++) {
			if (board.charAt(i) == 'X') {
				cnt++;
			} else {
				fillBoard(cnt);
				cnt = 0;
				if (fail)
					break;
				sb.append(".");

			}
		}
		fillBoard(cnt);
		if (fail) {
			System.out.println(-1);
		} else {

			System.out.println(sb);
		}

	}

}