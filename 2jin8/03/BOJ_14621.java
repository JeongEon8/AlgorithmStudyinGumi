import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14621 {

	static int N, M;
	static int[] parents;
	static char[] univ;
	static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.d, e2.d));

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		univ = new char[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			univ[i] = st.nextToken().charAt(0);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if (univ[u] != univ[v]) { // 남초 대학교와 여초 대학교를 잇는 간선만 넣기
				pq.offer(new Edge(u, v, d));
			}
		}
		System.out.println(makeMinLen());
	}

	static int makeMinLen() {
		int group = N, minLen = 0;
		make();
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			// 두 대학교가 연결되지 않았으면 연결하기
			if (union(now.u, now.v)) {
				group--;
				minLen += now.d;
			}

			if (group == 1) {
				return minLen;
			}
		}
		return -1;
	}

	static void make() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (a == parents[a])
			return a;

		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	static class Edge {
		int u, v, d;

		public Edge(int u, int v, int d) {
			this.u = u;
			this.v = v;
			this.d = d;
		}
	}
}
