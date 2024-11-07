import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		List<Integer> tips = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(in.readLine());
			tips.add(num);

		}
		Collections.sort(tips, Collections.reverseOrder());
		long ans = 0;
		for (int i = 0; i < n; i++) {
			ans += Math.max(tips.get(i) - i, 0);
		}
		System.out.println(ans);
	}

}