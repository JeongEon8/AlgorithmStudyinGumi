import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int m = Integer.parseInt(split[0]);
		int n = Integer.parseInt(split[1]);
		split = in.readLine().split(" ");
		List<Integer> snackList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			snackList.add(Integer.parseInt(split[i]));
		}
		Collections.sort(snackList, Collections.reverseOrder());
		int left = 1;
		int right = snackList.get(0);
		int mid = (left + right) / 2;
		while (left < right) {
			mid = (left + right) / 2;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				int current = snackList.get(i);
				if (mid > current)
					break;
				cnt += current / mid;
			}
			if (cnt >= m) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int current = snackList.get(i);
			if (left > current)
				break;
			cnt += current / left;
		}
		if (cnt >= m) {
			System.out.println(left);
		} else {
			System.out.println(left - 1);
		}

	}
}