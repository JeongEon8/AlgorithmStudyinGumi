import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, r, q;
	static List<Integer>[] connect;
	static Node[] nodes;

	static class Node {
		int parent, size, num;
		List<Integer> childs;

		public Node(int num) {
			this.num = num;
			this.parent = -1;
			this.size = 0;
			this.childs = new ArrayList<Integer>();
		}

	}

	static int makeTree(int current) {
		int size = 0;

		for (int connectNode : connect[nodes[current].num]) {
			if (connectNode != nodes[current].parent) {
				nodes[connectNode].parent = nodes[current].num;
				nodes[current].childs.add(connectNode);
				size += makeTree(connectNode);
			}
		}

		return nodes[current].size = size + 1;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		connect = new List[n + 1];
		nodes = new Node[n + 1];
		for (int i = 0; i <= n; i++) {
			connect[i] = new ArrayList<Integer>();
			nodes[i] = new Node(i);
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			connect[u].add(v);
			connect[v].add(u);
		}
		makeTree(r);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < q; i++) {
			int query = Integer.parseInt(in.readLine());
			sb.append(nodes[query].size).append("\n");
		}
		System.out.println(sb);

	}

}