import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split(" ");
		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(split[i]);
		}

		int x = Integer.parseInt(br.readLine());

		Arrays.sort(nums);
		int ans = 0;
		int start = 0, end = n - 1;
		while (start < end) {

			if (nums[start] + nums[end] == x) {
				ans++;
				start++;
				end--;
			} else if (nums[start] + nums[end] > x) {
				end--;
			} else {
				start++;
			}

		}

		System.out.println(ans);

	}

}