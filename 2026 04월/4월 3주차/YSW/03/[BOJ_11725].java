import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] adj = new ArrayList[N + 1];
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		int[] parent = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			adj[u].add(v);
			adj[v].add(u);
		}

		queue.add(1);
		visited[1] = true;
		while (!queue.isEmpty()) {
			int curr = queue.poll();

			for (int next : adj[curr]) {
				if (!visited[next]) {
					parent[next] = curr;
					queue.add(next);
					visited[next] = true;
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			sb.append(parent[i]).append('\n');
		}

		System.out.println(sb);
	}
}