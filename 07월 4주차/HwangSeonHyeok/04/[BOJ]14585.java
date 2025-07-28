import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static long[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new int[301][301];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[y][x] = Math.max(m - x - y,0);
		}
		dp = new long[301][301];
		dp[0][0] = graph[0][0];
		for (int i = 1; i <= 300; i++) {
			dp[0][i] = dp[0][i - 1] + graph[0][i];
			dp[i][0] = dp[i - 1][0] + graph[i][0];
		}
		for (int i = 1; i <= 300; i++) {
			for (int j = 1; j <= 300; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + graph[i][j];
			}
		}
		System.out.println(dp[300][300]);

	}

}