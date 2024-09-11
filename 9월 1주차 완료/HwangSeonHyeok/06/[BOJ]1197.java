import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static class Edge implements Comparable<Edge> {
		int from, to, w;

		public Edge(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}

	static int[] parents;

	private static int findSet(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}

	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int V = Integer.parseInt(split[0]);
		int E = Integer.parseInt(split[1]);
		Edge[] eArr = new Edge[E];
		for (int i = 0; i < E; i++) {
			split = in.readLine().split(" ");
			int from = Integer.parseInt(split[0]);
			int to = Integer.parseInt(split[1]);
			int w = Integer.parseInt(split[2]);
			eArr[i] = new Edge(from, to, w);
		}
		Arrays.sort(eArr);
		parents = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
		int ans = 0;
		int cnt = 0;
		for (Edge edge : eArr) {
			if (union(edge.from, edge.to)) {
				ans += edge.w;
				cnt++;
				if(cnt==V-1) {
					break;
				}
			}
		}
		System.out.println(ans);

	}

}