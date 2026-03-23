import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14465 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		boolean[] isBroken = new boolean[N + 1];

		for (int i = 0; i < B; i++) {
			int brokenIndex = Integer.parseInt(br.readLine());
			isBroken[brokenIndex] = true;
		}

		int count = 0;
		for (int i = 1; i <= K; i++) {
			if (isBroken[i] == true) {
				count++;
			}
		}

		int minCount = count;
		for (int i = K + 1; i <= N; i++) {
			if (isBroken[i]) {
				count++;
			}

			if (isBroken[i - K]) {
				count--;
			}

			minCount = Math.min(minCount, count);
		}

		System.out.println(minCount);
	}
}