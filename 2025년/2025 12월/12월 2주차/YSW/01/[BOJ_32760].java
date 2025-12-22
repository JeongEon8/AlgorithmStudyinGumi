import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_32760 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);

		int[] cnt = new int[100001];
		for (int i = 0; i < M; i++) {
			inputs = br.readLine().split(" ");
			int from = Integer.parseInt(inputs[0]);
			int to = Integer.parseInt(inputs[1]);
			if (from > to) {
				cnt[from]++;
			} else {
				cnt[to]++;
			}
		}

		for (int i = 2; i <= N; i++) {
			if (cnt[i] == 0) {
				sb.append("N");
			} else if (cnt[i] == i - 1) {
				sb.append("E");
			} else {
				System.out.println(-1);
				return;
			}
		}

		System.out.println(sb.toString());
	}
}