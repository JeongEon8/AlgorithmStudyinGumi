import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BOJ_4358 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();

		String input;
		int totalCount = 0;
		while ((input = br.readLine()) != null) {
			hashmap.put(input, hashmap.getOrDefault(input, 0) + 1);
			totalCount++;
		}

		ArrayList<String> list = new ArrayList<String>(hashmap.keySet());
		Collections.sort(list);

		for (String key : list) {
			double percent = (double) hashmap.get(key) * 100 / totalCount;
			sb.append(key).append(" ").append(String.format("%.4f", percent)).append("\n");
		}

		System.out.println(sb);
	}
}