import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1967 {
	public static ArrayList<Node>[] adj;
	public static int N;
	public static int maxLength = 0;
	public static int furthestNode = 1;
	public static boolean[] visited;

	public static class Node {
		int target;
		int weight;

		public Node(int target, int weight) {
			this.target = target;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adj[parent].add(new Node(child, weight));
			adj[child].add(new Node(parent, weight));
		}

		maxLength = 0;
		visited = new boolean[N + 1];
		dfs(1, 0);

		maxLength = 0;
		visited = new boolean[N + 1];
		dfs(furthestNode, 0);

		System.out.println(maxLength);
	}

	public static void dfs(int current, int distance) {
		visited[current] = true;
		if (maxLength < distance) {
			maxLength = distance;
			furthestNode = current;
		}

		for (Node node : adj[current]) {
			if (!visited[node.target]) {
				dfs(node.target, distance + node.weight);
			}
		}
	}
}