import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int ans = 0;
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int remain = 4 - arr[right];
			right--;
			ans++;
			while (left <= right && arr[left] <= remain) {
				remain -= arr[left];
				left++;
			}
		}
		System.out.println(ans);

	}

}