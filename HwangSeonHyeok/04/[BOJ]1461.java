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
		int m = Integer.parseInt(split[1]);
		List<Integer> minus = new ArrayList<>();
		List<Integer> plus = new ArrayList<>();
		split = in.readLine().split(" ");
		int max = 0;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(split[i]);
			if (Math.abs(num) > max)
				max = Math.abs(num);
			if (num > 0) {
				plus.add(num);
			} else {
				minus.add(num);
			}
		}
		Collections.sort(plus, Collections.reverseOrder());
		Collections.sort(minus);
		int ans = -max;
		for (int i = 0; i < plus.size();) {
			ans += plus.get(i) * 2;
			i += m;
		}
		for (int i = 0; i < minus.size();) {
			ans -= minus.get(i) * 2;
			i += m;
		}
		System.out.println(ans);

	}

}