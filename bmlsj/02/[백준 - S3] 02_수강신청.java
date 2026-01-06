import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);

		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		String[] students = new String[M];
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			students[i] = input;
		}

		int idx = 0;
		for (int i = M - 1; i >= 0; i--) {
			if (map.containsKey(students[i]))
				continue;
			map.put(students[i], idx++);
		}
		
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((e1, e2) -> e2.getValue() - e1.getValue());
		
		idx = 0;
		for (Map.Entry<String, Integer> entry : list) {
			if (idx == N) break;
		    System.out.println(entry.getKey());
		    idx++;
		}

	}

}