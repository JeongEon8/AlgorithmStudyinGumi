import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		int[][] graph = new int[n + 2][m + 2];
		for (int i = 1; i <= n; i++) {
			split = in.readLine().split(" ");
			for (int j = 1; j <= m; j++) {
				graph[i][j] = Integer.parseInt(split[j - 1]);
			}
		}

		int ans = n * m * 2;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				ans += Math.max(0, graph[i][j] - graph[i - 1][j]);
				ans += Math.max(0, graph[i][j] - graph[i + 1][j]);
				ans += Math.max(0, graph[i][j] - graph[i][j - 1]);
				ans += Math.max(0, graph[i][j] - graph[i][j + 1]);
			}
		}
		System.out.println(ans);
	}

}