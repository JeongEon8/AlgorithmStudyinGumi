import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_18113 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int K = Integer.parseInt(inputs[1]);
		int M = Integer.parseInt(inputs[2]);

		List<Integer> list = new ArrayList<>();
		int maxLen = 0;

		for (int i = 0; i < N; i++) {
			int L = Integer.parseInt(br.readLine());
			if (maxLen < L) {
				maxLen = L;
			}

			if (L >= 2 * K) {
				if (L - 2 * K > 0)
					list.add(L - 2 * K);
			} else if (L > K) {
				if (L - K > 0)
					list.add(L - K);
			}
		}

		if (list.isEmpty()) {
			System.out.println(-1);
			return;
		}

		int low = 1;
		int high = maxLen;
		int ans = -1;

		while (low <= high) {
			int mid = (low + high) / 2;

			long count = 0;
			for (int len : list) {
				count += (len / mid);
			}

			if (count >= M) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		System.out.println(ans);
	}
}