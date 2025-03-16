import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		Arrays.sort(arr);
		int ans = 2;
		if (n < 3) {
			ans = n;
		} else {
			int left = 0;
			for (int i = 2; i < n; i++) {
				if (arr[left] + arr[left + 1] <= arr[i]) {
					ans = Math.max(ans, i - left);
					while (left < i - 1) {
						left++;
						if (arr[left] + arr[left + 1] > arr[i])
							break;
					}
				}
			}
			ans = Math.max(ans, n - left);
		}

		System.out.println(ans);

	}

}
