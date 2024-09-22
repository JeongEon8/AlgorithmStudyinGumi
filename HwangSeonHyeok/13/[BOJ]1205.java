import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int sc = Integer.parseInt(split[1]);
		int p = Integer.parseInt(split[2]);
		if (n == 0) {
			System.out.println(1);
		} else {
			List<Integer> ranking = new ArrayList<>();
			split = in.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				ranking.add(Integer.parseInt(split[i]));
			}
			Collections.sort(ranking, Collections.reverseOrder());
			int ans = 1;
			if (n == p && sc <= ranking.get(n - 1)) {
				ans = -1;
			} else {
				for (Integer ranker : ranking) {
					if (ranker <= sc) break;
					ans++;
				}
			}
			System.out.println(ans);
		}
	}

}