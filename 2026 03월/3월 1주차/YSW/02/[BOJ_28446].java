import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_28446 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>(M);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());

			if (command == 1) {
				int lockerIndex = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				hashmap.put(weight, lockerIndex);
			} else {
				int weight = Integer.parseInt(st.nextToken());
				sb.append(hashmap.get(weight)).append("\n");
			}
		}

		System.out.print(sb);
	}
}