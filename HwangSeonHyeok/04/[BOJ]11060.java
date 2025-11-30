import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int MAX_COUNT = 1010;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] maze = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			maze[i] = Integer.parseInt(st.nextToken());
			dp[i] = MAX_COUNT;
		}
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			if (dp[i] == MAX_COUNT)
				continue;
			for (int j = 1; j <= maze[i]; j++) {
				if (i + j < n) {
					dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
				}
			}
		}
		if (dp[n - 1] == MAX_COUNT) {
			System.out.println(-1);
		} else {
			System.out.println(dp[n - 1]);
		}

	}

}