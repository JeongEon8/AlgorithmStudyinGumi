import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[][] costs = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < n; j++) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int allWorking = (1 << n) - 1;
		int[] dp = new int[allWorking + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < allWorking; i++) {
			if (dp[i] == Integer.MAX_VALUE)
				continue;
			int workNum = Integer.bitCount(i);
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) == 0) {
					int nextVisited = i | (1 << j);
					int nextCost = dp[i] + costs[j][workNum];
					dp[nextVisited] = Math.min(dp[nextVisited], nextCost);
				}
			}
		}
		System.out.println(dp[allWorking]);
	}

}