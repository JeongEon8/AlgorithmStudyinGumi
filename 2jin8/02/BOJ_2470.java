import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		// 용액 하나를 선택한 후, 혼합값이 가장 0에 가까워지는 다른 용액 선택하기
		int a = -1, b = -1, minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < N - 1; i++) {
			int c = binarySearch(i);
			int diff = Math.abs(arr[i] + arr[c]);
			if (diff < minDiff) {
				minDiff = diff;
				a = arr[i];
				b = arr[c];
			}
		}
		System.out.println(a + " " + b);
	}

	static int binarySearch(int start) {
		int left = start + 1, right = N - 1;
		int ans = -1, minDiff = 2_000_000_000;

		while (left <= right) {
			int mid = (left + right) / 2;
			int diff = arr[start] + arr[mid];

			// 합이 0이면 바로 종료
			if (diff == 0)
				return mid;

			// minDiff보다 작은 경우 갱신
			int absDiff = Math.abs(diff);
			if (absDiff < minDiff) {
				minDiff = absDiff;
				ans = mid;
			}

			// 혼합값이 음수면 더 큰 값을 더하도록 => 우측으로
			if (diff < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return ans;
	}
}
