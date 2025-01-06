import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static int[] parents;
	private static int N,M; 
	private static Edge[] edgeList;


	private static void makeSet() {

		parents = new int[N+1];

		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
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

	static class Edge implements Comparable<Edge> {
		public int from;
		public int to;
		public int weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {

			return this.weight - o.weight;
		}

	}

	

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);

		edgeList = new Edge[M];

		int from, to, weight;

		for (int i = 0; i < M; i++) {
			split = in.readLine().split(" ");
			from = Integer.parseInt(split[0]);
			to = Integer.parseInt(split[1]);
			weight = Integer.parseInt(split[2]);
			edgeList[i] = new Edge(from, to, weight);

		}
		Arrays.sort(edgeList);
		makeSet();
		int result = 0;
		int count = 0;
		if(N!=2) {
			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) {
					result += edge.weight;
	
					if (++count == N - 2) {
						break;
					}
				}
			}
		}
		
		System.out.println(result);

	}
}