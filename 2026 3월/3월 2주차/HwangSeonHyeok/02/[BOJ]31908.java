import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String name = st.nextToken();
			String sentence = st.nextToken();
			if ("-".equals(sentence)) {
				continue;
			}
			if (!map.containsKey(sentence)) {
				map.put(sentence, new ArrayList<String>());
			}
			map.get(sentence).add(name);
		}
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (List<String> list : map.values()) {
			if (list.size() == 2) {
				cnt++;
				sb.append(list.get(0)).append(" ").append(list.get(1)).append('\n');
			}
		}
		System.out.println(cnt);
		System.out.println(sb);

	}

}