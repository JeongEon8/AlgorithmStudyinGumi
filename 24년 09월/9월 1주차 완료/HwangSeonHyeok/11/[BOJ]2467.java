import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		String[] split = in.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		Arrays.sort(arr);
		int idx1 = 0, idx2 = 0;
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) {
			int tmp = -arr[i];
			int left = i + 1;
			int right = n - 1;
			int mid = 0;
			while (left < right) {
				mid = (left + right) / 2 + 1;
				if (arr[mid] > tmp) {
					right = mid - 1;
				} else {
					left = mid;
				}
			}
			mid = (left + right) / 2;
			int compdiff;
			if (mid == n - 1) {
				compdiff = Math.abs(arr[mid] - tmp);
			} else {
				int absMid = Math.abs(arr[mid] - tmp);
				int absMidPlus = Math.abs(arr[mid + 1] - tmp);
				if (absMid > absMidPlus) {
					compdiff = absMidPlus;
					mid = mid + 1;
				} else {
					compdiff = absMid;
				}
			}
			if (diff > compdiff) {
				diff = compdiff;
				idx1 = i;
				idx2 = mid;
			}
		}
		System.out.println(arr[idx1] + " " + arr[idx2]);

	}

}