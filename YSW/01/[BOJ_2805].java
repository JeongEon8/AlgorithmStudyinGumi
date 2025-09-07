import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2805 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		int N = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);
		strArr = br.readLine().split(" ");
		int[] trees = new int[N];
		int maxHeight = 0;

		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(strArr[i]);
			if (trees[i] > maxHeight) {
				maxHeight = trees[i];
			}
		}

		long start = 0;
		long end = maxHeight;
		long result = 0;

		while (start <= end) {
			long mid = (start + end) / 2;
			long cutLengthSum = 0;

			for (int treeHeight : trees) {
				if (treeHeight > mid) {
					cutLengthSum += treeHeight - mid;
				}
			}

			if (cutLengthSum >= M) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(result);
	}
}