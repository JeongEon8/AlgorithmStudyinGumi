import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] alphabetStrokes = { 3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int total = n + m;
		st = new StringTokenizer(in.readLine());
		char[] nameA = st.nextToken().toCharArray();
		char[] nameB = st.nextToken().toCharArray();
		int[] testArr = new int[total];
		int idx = 0;
		for (int i = 0; i < Math.max(n, m); i++) {
			if (i < n) {
				testArr[idx++] = alphabetStrokes[nameA[i] - 'A'];
			}
			if (i < m) {
				testArr[idx++] = alphabetStrokes[nameB[i] - 'A'];
			}
		}
		for (int i = total; i > 2; i--) {
			for (int j = 0; j < i - 1; j++) {
				testArr[j] = (testArr[j] + testArr[j + 1]) % 10;
			}
		}
		System.out.println(testArr[0] * 10 + testArr[1] + "%");
	}

}