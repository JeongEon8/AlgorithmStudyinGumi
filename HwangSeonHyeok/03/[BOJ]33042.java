import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());

		int[][] tiles = new int[4][10];
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			String str = st.nextToken();
			int num = (int) (str.charAt(0) - '0');
			char suit = str.charAt(1);
			int suitIdx = 0;
			if (suit == 'm') {
				suitIdx = 0;
			} else if (suit == 'p') {
				suitIdx = 1;
			} else if (suit == 's') {
				suitIdx = 2;
			} else {
				suitIdx = 3;
			}
			tiles[suitIdx][num]++;
			if (tiles[suitIdx][num] > 4) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);

	}

}