import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Edge {
		int dest;
		int dist;

		public Edge(int dest, int dist) {
			super();
			this.dest = dest;
			this.dist = dist;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		List<Edge>[] list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Edge(b, c));
			list[b].add(new Edge(a, c));
		}
		Queue<Integer> q = new ArrayDeque<>();
		long[] dist = new long[n + 1];
		boolean[] visit = new boolean[n + 1];
		q.add(1);
		visit[1] = true;
		while (!q.isEmpty()) {
			int current = q.poll();
			for (Edge e : list[current]) {
				int next = e.dest;
				if (!visit[next]) {
					dist[next] = dist[current] + e.dist;
					visit[next] = true;
					q.add(next);

				}
			}
		}
		long ans = 0;
		for (int i = 0; i <= n; i++) {
			ans = Math.max(ans, dist[i]);
		}
		System.out.println(ans);

	}

}