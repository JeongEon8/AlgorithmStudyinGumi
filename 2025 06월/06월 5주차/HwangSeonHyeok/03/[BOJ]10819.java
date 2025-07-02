import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] arr;
	static boolean[] selected;
	static int n, ans = 0;

	static void solve(int idx, int num, int sum) {
		if (num == n) {
			ans = Math.max(ans, sum);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!selected[i]) {
				selected[i] = true;
				solve(i, num + 1, sum + Math.abs(arr[idx] - arr[i]));
				selected[i] = false;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");
		arr = new int[n];
		selected = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		for (int i = 0; i < n; i++) {
			selected[i] = true;
			solve(i, 1, 0);
			selected[i] = false;
		}
		System.out.println(ans);
	}

}