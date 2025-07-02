import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);
		split = in.readLine().split(" ");
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(split[i]);
		}
		Arrays.sort(nums);
		int ans = 0;
		for (int i = 1; i <= k; i++) {
			ans += nums[n - i];
		}
		ans -= k * (k - 1) / 2;
		System.out.println(ans);
	}

}