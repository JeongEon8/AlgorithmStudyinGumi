import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1980 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		if (n > m) {
			int temp = n;
			n = m;
			m = temp;
		}

		int length = t / n;
		int minCoke = t;
		int maxBurger = 0;
		for (int i = 0; i <= length; i++) {
			int nBurger = i;
			int currentCoke = t - n * nBurger;
			int mBurger = currentCoke / m;
			currentCoke = currentCoke % m;

			if (minCoke > currentCoke) {
				minCoke = currentCoke;
				maxBurger = nBurger + mBurger;
			} else if (minCoke == currentCoke) {
				maxBurger = Math.max(maxBurger, nBurger + mBurger);
			}
		}

		System.out.println(maxBurger + " " + minCoke);
	}
}