import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int allVisited = (1 << n) - 1;
		int[][] graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[allVisited + 1][n];
		for (int i = 0; i <= allVisited; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		dp[1][0] = 0;
		for (int mask = 3; mask <= allVisited; mask += 2) {
			for (int i = 1; i < n; i++) {
				if ((mask & (1 << i)) == 0)
					continue;
				int prev = mask ^ (1 << i);
				for (int j = 0; j < n; j++) {
					if (graph[j][i] == 0 || (mask & (1 << j)) == 0 || dp[prev][j] == Integer.MAX_VALUE)
						continue;
					dp[mask][i] = Math.min(dp[mask][i], dp[prev][j] + graph[j][i]);
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) {
			if (dp[allVisited][i] != Integer.MAX_VALUE && graph[i][0] != 0) {
				ans = Math.min(ans, dp[allVisited][i] + graph[i][0]);
			}
		}
		System.out.println(ans);

	}

}