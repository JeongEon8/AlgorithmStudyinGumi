import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int d = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<Character, Integer> map = new HashMap<>();
		map.put('H', 0);
		map.put('Y', 0);
		map.put('U', 0);
		int energy = 0;
		int others = 0;
		for (int i = 0; i < n; i++) {
			char c = str.charAt(i);
			if (map.containsKey(c)) {
				energy += Math.min(others * d, m + d);
				others = 0;
				map.put(c, map.get(c) + 1);
			} else {
				others++;
			}
		}
		energy += Math.min(others * d, m + d);
		int hyu = Integer.MAX_VALUE;
		for (int cnt : map.values()) {
			hyu = Math.min(hyu, cnt);
		}
		if (energy == 0) {
			System.out.println("Nalmeok");
		} else {
			System.out.println(energy);
		}
		if (hyu == 0) {
			System.out.println("I love HanYang University");
		} else {
			System.out.println(hyu);
		}

	}

}