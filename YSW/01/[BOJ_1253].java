import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1253 {
	public static int[] number;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		String[] strArr = br.readLine().split(" ");
		number = new int[N];

		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(strArr[i]);
		}

		Arrays.sort(number);

		for (int i = N - 1; i >= 0; i--) {
			int target = number[i];
			int right = N - 1;
			int left = 0;
			while (left < right) {
				if (right == i) {
					right--;
					continue;
				} else if (left == i) {
					left++;
					continue;
				}

				int sum = number[left] + number[right];

				if (sum == target) {
					count++;
					break;
				} else if (sum > target) {
					right--;
				} else {
					left++;
				}
			}
		}

		System.out.println(count);
	}

}
