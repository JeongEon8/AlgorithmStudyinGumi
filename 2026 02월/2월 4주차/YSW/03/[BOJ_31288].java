import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_31288 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());

		for (int testCase = 0; testCase < T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String P = st.nextToken();

			if (N == 1) {
				sb.append("4 2\n");
				continue;
			}

			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += (P.charAt(i) - '0');
			}

			for (int i = 0; i < N; i++) {
				int currentDigit = P.charAt(i) - '0';
				boolean found = false;

				for (int target = 1; target <= 9; target++) {
					if (target == currentDigit)
						continue;

					int newSum = sum - currentDigit + target;

					if (newSum % 3 == 0) {
						StringBuilder Q = new StringBuilder(P);
						Q.setCharAt(i, (char) (target + '0'));
						sb.append(Q.toString()).append(" 3\n");
						found = true;
						break;
					}
				}

				if (!found && i > 0) {
					int newSum = sum - currentDigit + 0;
					if (newSum % 3 == 0) {
						StringBuilder Q = new StringBuilder(P);
						Q.setCharAt(i, '0');
						sb.append(Q.toString()).append(" 3\n");
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}