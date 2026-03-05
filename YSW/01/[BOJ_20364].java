import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20364 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		boolean[] ground = new boolean[N + 1];

		for (int i = 0; i < Q; i++) {
			int target = Integer.parseInt(br.readLine());
			int route = target;
			int firstBlocked = 0;
			while (route > 0) {
				if (ground[route]) {
					firstBlocked = route;
				}
				route /= 2;
			}

			if (firstBlocked == 0) {
				ground[target] = true;
			}
			sb.append(firstBlocked).append("\n");
		}

		System.out.println(sb.toString());
	}
}