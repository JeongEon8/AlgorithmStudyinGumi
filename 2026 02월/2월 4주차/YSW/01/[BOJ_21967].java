import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21967 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int maxLength = 0;
		int[] numCounts = new int[11];
		int left = 0;
		for (int right = 0; right < n; right++) {
			numCounts[nums[right]]++;
			while (true) {
				int max = 0;
				int min = 11;
				for (int i = 1; i <= 10; i++) {
					if (numCounts[i] != 0) {
						max = Math.max(max, i);
						min = Math.min(min, i);
					}
				}
				if (max - min <= 2) {
					break;
				}

				numCounts[nums[left]]--;
				left++;
			}

			maxLength = Math.max(maxLength, right - left + 1);
		}

		System.out.println(maxLength);
	}
}