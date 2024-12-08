import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static Node[] nodes;
	static boolean[] visited;
	static int ans;

	static class Node {
		int num;
		List<Integer> roots = new ArrayList<>();

		public Node(int num) {
			super();
			this.num = num;
		}

	}

	static void dfs(int current, int depth) {
		visited[current] = true;
		boolean isLeaf = true;

		for (int next : nodes[current].roots) {
			if (!visited[next]) {
				isLeaf = false;
				dfs(next, depth + 1);
			}
		}
		if (isLeaf) {
			ans += depth;

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		nodes = new Node[n + 1];
		visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			nodes[i] = new Node(i);
		}
		for (int i = 1; i < n; i++) {
			String[] split = in.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			nodes[a].roots.add(b);
			nodes[b].roots.add(a);
		}
		dfs(1, 0);
		if (ans % 2 == 1) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

}