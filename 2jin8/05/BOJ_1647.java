import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1647 {

	static int N, M;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Edge[] edges = new Edge[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(a, b, c);
		}

		Arrays.sort(edges);

		make();
		int weight = 0, group = N;
		if (group == 2) { // 이미 두 개의 마을로 분할된 경우
			System.out.println(0);
			return;
		}
		
		for (Edge edge : edges) {
			// 대표자가 다르다면 그룹의 수 1개 감소 & 가중치 더하기
			if (union(edge.a, edge.b)) {
				weight += edge.w;
				// 마을을 두 개로 분리하면 종료하기
				if (--group == 2)
					break;
			}
		}
		System.out.println(weight);
	}

	static void make() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	static int findRoot(int a) {
		if (a == parents[a])
			return a;

		return parents[a] = findRoot(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findRoot(a);
		int bRoot = findRoot(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	static class Edge implements Comparable<Edge> {
		int a, b, w;

		public Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w; // 가중치 기준 오름차순 정렬
		}
	}
}
