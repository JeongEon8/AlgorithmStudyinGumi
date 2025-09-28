import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		Map<List<Integer>, Integer> patterns = new HashMap<>();
		for (int i = 0; i < m; i++) {
			int[] space = new int[n];
			Set<Integer> set = new HashSet<>();
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < n; j++) {
				int pSize = Integer.parseInt(st.nextToken());
				space[j] = pSize;
				set.add(pSize);
			}
			List<Integer> orderedSize = new ArrayList<>(set);
			Collections.sort(orderedSize);
			Map<Integer, Integer> sizeToPattern = new HashMap();
			for (int j = 0; j < orderedSize.size(); j++) {
				sizeToPattern.put(orderedSize.get(j), j);
			}
			List<Integer> pattern = new ArrayList<>();
			for (int size : space) {
				pattern.add(sizeToPattern.get(size));
			}
			patterns.put(pattern, patterns.getOrDefault(pattern, 0) + 1);
		}
		int ans = 0;
		for (int p : patterns.values()) {
			ans += p * (p - 1) / 2;
		}
		System.out.println(ans);
	}

}