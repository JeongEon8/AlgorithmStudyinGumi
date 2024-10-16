import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1446 {

	static int N, D, INF = 100_000_001;
	static ArrayList<Edge>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		graph = new ArrayList[D + 1];
		for (int i = 0; i <= D; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if (e <= D) {
				graph[e].add(new Edge(s, d));
			}
		}

		int[] dp = new int[D + 1];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for (int i = 1; i <= D; i++) {
			// 한 칸씩 이동하기
			dp[i] = dp[i - 1] + 1;

			// 지름길이 있다면 확인하기
			for (Edge prev : graph[i]) {
				dp[i] = Math.min(dp[i], dp[prev.x] + prev.d);
			}
		}
		System.out.println(dp[D]);
	}

	static class Edge {
		int x, d;

		public Edge(int x, int d) {
			this.x = x;
			this.d = d;
		}
	}
}
