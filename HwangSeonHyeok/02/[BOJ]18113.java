import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);
		int m = Integer.parseInt(split[2]);
		List<Integer> kimbaps = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int kimbap = Integer.parseInt(in.readLine());
			if (kimbap > 2 * k) {
				kimbap -= 2 * k;
			} else if (kimbap == 2 * k) {
				continue;
			} else if (kimbap > k) {
				kimbap -= k;
			} else {
				continue;
			}
			kimbaps.add(kimbap);
		}
		int left = 1;
		int right = 1000000000;
		while (left < right) {
			int mid = (left + right) / 2;
			int cnt = 0;
			for (int kimbap : kimbaps) {
				cnt += kimbap / mid;
			}
			if (cnt >= m) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		int cnt = 0;
		for (int kimbap : kimbaps) {
			cnt += kimbap / left;
		}
		if (cnt >= m) {
			System.out.println(left);
		} else {
			if (left - 1 > 0)
				System.out.println(left - 1);
			else {
				System.out.println(-1);
			}
		}

	}

}