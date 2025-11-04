import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Map<String, Integer> map = new HashMap<>();
		int[] time = { 4, 6, 4, 10 };
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				String[] workers = in.readLine().split(" ");
				for (String worker : workers) {
					if (worker.equals("-"))
						continue;
					map.put(worker, map.getOrDefault(worker, 0) + time[j]);
				}
			}
		}
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int t : map.values()) {
			min = Math.min(min, t);
			max = Math.max(max, t);
		}
		if (max - min <= 12) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

}