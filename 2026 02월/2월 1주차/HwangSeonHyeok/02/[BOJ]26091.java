import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] stats = new int[n];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			stats[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(stats);
		int left = 0;
		int right = n - 1;
		int ans = 0;
		while (left < right) {
			if (stats[left] + stats[right] >= m) {
				ans++;
				left++;
				right--;
			} else {
				left++;
			}
		}
		System.out.println(ans);
	}

}