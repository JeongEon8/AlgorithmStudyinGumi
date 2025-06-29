import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static List<Integer>[] graph;
	public static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);

		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			split = br.readLine().split(" ");
			int u = Integer.parseInt(split[0]);
			int v = Integer.parseInt(split[1]);
			graph[u].add(v);
			graph[v].add(u);
		}

		// System.out.println(Arrays.toString(graph));
		visited = new boolean[N + 1];
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				connect(i);
				ans++;
			}
		}

		System.out.println(ans);

	}

	public static void connect(int node) {

		visited[node] = true;

		for (int next : graph[node]) {
			if (!visited[next]) {
				visited[next] = true;
				connect(next);
			}
		}
	}

}