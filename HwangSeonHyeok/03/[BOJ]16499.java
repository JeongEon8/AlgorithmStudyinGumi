import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Map<String, Boolean> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			char[] cArr = in.readLine().toCharArray();
			Arrays.sort(cArr);
			StringBuilder sb = new StringBuilder();
			sb.append(cArr);
			if (!map.containsKey(sb.toString())) {
				map.put(sb.toString(), true);
			}
		}
		System.out.println(map.size());

	}

}