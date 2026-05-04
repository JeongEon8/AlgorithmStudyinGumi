import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_27973 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int Q = Integer.parseInt(br.readLine());

		long multiplier = 1;
		long origin = 1;
		long adder = 0;
		for (int i = 0; i < Q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command != 3) {
				long x = Long.parseLong(st.nextToken());
				if (command == 0) {
					adder += x;
				} else if (command == 1) {
					multiplier *= x;
					adder *= x;
				} else if (command == 2) {
					origin += x;
				}
			} else {
				long res = multiplier * origin + adder;
				sb.append(res).append("\n");
			}
		}

		System.out.println(sb);
	}
}