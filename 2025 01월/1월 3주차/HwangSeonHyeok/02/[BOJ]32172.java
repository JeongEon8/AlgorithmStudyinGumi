import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Set<Integer> set = new HashSet();
		int ans = 0;
		set.add(ans);
		for (int i = 1; i <= n; i++) {
			int tmp = ans;
			tmp -= i;
			if (tmp < 0 || set.contains(tmp)) {
				ans += i;
			} else {
				ans = tmp;
			}
			set.add(ans);
		}
		System.out.println(ans);

	}

}