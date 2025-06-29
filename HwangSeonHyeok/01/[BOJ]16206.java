import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		Integer[] cakes = new Integer[n];
		split = in.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			cakes[i] = Integer.parseInt(split[i]);
		}
		Arrays.sort(cakes, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 % 10 == 0 && o2 % 10 == 0) {
					return o1 - o2;
				}
				if (o1 % 10 == 0) {
					return -1;
				}
				if (o2 % 10 == 0) {
					return 1;
				}
				return o1 - o2;
			}
		});
		int ans = 0;
		for (int cake : cakes) {
			int cutCnt = (cake - 1) / 10;
			if (m >= cutCnt) {
				m -= cutCnt;
				ans += cutCnt;
				if (cake % 10 == 0)
					ans++;
			} else {
				ans += m;
				break;
			}
		}
		System.out.println(ans);

	}

}