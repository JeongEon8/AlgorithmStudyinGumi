import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		boolean isAble = true;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] cards = new int[n][m];
		int zeroCard = 0;
		int oneCard = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++) {
				int card = Integer.parseInt(st.nextToken());
				cards[i][j] = card;
				if (card % 2 == 0) {
					zeroCard++;
				} else {
					oneCard++;
				}
			}
		}
		if (oneCard % 2 != 0 || zeroCard % 2 != 0) {
			isAble = false;
		}
		if (isAble) {
			boolean canRemove = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (j + 1 < m && cards[i][j] == cards[i][j + 1]) {
						canRemove = true;
						break;
					}
					if (i + 1 < n && cards[i][j] == cards[i + 1][j]) {
						canRemove = true;
						break;
					}
				}
				if (canRemove)
					break;
			}
			if (!canRemove)
				isAble = false;
		}

		if (isAble) {
			System.out.println(1);
		} else {
			System.out.println(-1);
		}

	}

}