import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_15787 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long[] trains = new long[n];
		HashSet<Long> hashSet = new HashSet<Long>();
		int limit = 21;
		int filter = (1 << limit) - 2;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int trainIndex = Integer.parseInt(st.nextToken()) - 1;
			if (command == 1 || command == 2) {
				int seatNum = Integer.parseInt(st.nextToken());

				if (command == 1) {
					trains[trainIndex] |= (1 << seatNum);
				} else {
					trains[trainIndex] &= ~(1 << seatNum);
				}
			} else {
				if (command == 3) {
					trains[trainIndex] = (trains[trainIndex] << 1) & filter;
				} else {
					trains[trainIndex] = (trains[trainIndex] >> 1) & filter;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			hashSet.add(trains[i]);
		}

		System.out.println(hashSet.size());
	}
}