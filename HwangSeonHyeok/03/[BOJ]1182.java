import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n, s, ans;
	static int[] arr;

	static void solve(int step, int sum, boolean selected) {
		if (selected && sum == s)
			ans++;
		if (step == n) {
			return;
		}
		if (sum >= s && arr[step] > 0)
			return;
		solve(step + 1, sum + arr[step], true);
		solve(step + 1, sum, false);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		n = Integer.parseInt(split[0]);
		s = Integer.parseInt(split[1]);
		arr = new int[n];
		split = in.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		Arrays.sort(arr);
		solve(0, 0, false);
		System.out.println(ans);

	}

}