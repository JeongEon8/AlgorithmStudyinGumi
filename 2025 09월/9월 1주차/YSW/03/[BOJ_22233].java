import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_22233 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String[] strArr = br.readLine().split(" ");
		int N = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);

		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), 1);
		}

		for (int i = 0; i < M; i++) {
			strArr = br.readLine().split(",");
			for (int j = 0; j < strArr.length; j++) {
				if (map.containsKey(strArr[j])) {
					map.remove(strArr[j]);
				}
			}
			sb.append(map.size()).append("\n");
		}
		System.out.println(sb.toString());
	}
}