import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_30046 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] inputs = new String[3];

		for (int i = 0; i < 3; i++) {
			inputs[i] = br.readLine();
		}

		for (int h = 1; h <= 9; h++) {
			for (int j = 1; j <= 9; j++) {
				if (h == j)
					continue;
				for (int s = 1; s <= 9; s++) {
					if (h == s || j == s)
						continue;

					if (compare(inputs[0], inputs[1], h, j, s) < 0 && compare(inputs[1], inputs[2], h, j, s) < 0) {
						System.out.println("HJS! HJS! HJS!");
						return;
					}
				}
			}
		}

		System.out.println("Hmm...");
	}

	private static int compare(String s1, String s2, int h, int j, int s) {
		for (int i = 0; i < s1.length(); i++) {
			int v1 = getVal(s1.charAt(i), h, j, s);
			int v2 = getVal(s2.charAt(i), h, j, s);

			if (v1 < v2)
				return -1;
			if (v1 > v2)
				return 1;
		}
		return 0;
	}

	private static int getVal(char c, int h, int j, int s) {
		if (c == 'H')
			return h;
		if (c == 'J')
			return j;
		return s;
	}
}