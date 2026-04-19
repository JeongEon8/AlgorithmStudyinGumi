import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int nLen, n, k, ans = 0;
	static int[] arr;

	static void solve(int current) {
		if (current > n)
			return;
		ans = Math.max(ans, current);
		for (int i = k - 1; i >= 0; i--) {
			solve(current * 10 + arr[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		arr = new int[k];
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		solve(0);
		System.out.println(ans);

	}

}