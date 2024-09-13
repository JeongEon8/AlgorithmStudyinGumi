import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4386 {

	static int N;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		double[][] stars = new double[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stars[i][0] = Double.parseDouble(st.nextToken());
			stars[i][1] = Double.parseDouble(st.nextToken());
		}

		// Edge 정보 PQ에 넣기 (거리 기준 오름차순 정렬)
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Double.compare(e1.dist, e2.dist));
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				double x = Math.abs(stars[i][0] - stars[j][0]);
				double y = Math.abs(stars[i][1] - stars[j][1]);
				double dist = Math.sqrt(x * x + y * y);
				pq.add(new Edge(i, j, dist));
			}
		}

		double dist = 0.0;
		int group = N;
		make();
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			// 서로 다른 집합에 속해있으면 합칠 수 있음
			if (union(edge.u, edge.v)) {
				dist += edge.dist;
				group--;
			}

			// 모든 별이 연결되면 종료
			if (group == 1) break;
		}
		System.out.println(String.format("%.2f", dist));
	}

	static void make() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	static int find(int u) {
		if (u == parents[u])
			return u;

		return parents[u] = find(parents[u]);
	}

	static boolean union(int u, int v) {
		int uRoot = find(u);
		int vRoot = find(v);
		// 부모가 같은 경우(=같은 집합)
		if (uRoot == vRoot)
			return false;

		parents[vRoot] = uRoot; // 까먹지말자..!
		return true;
	}

	static class Edge {
		int u, v;
		double dist;

		public Edge(int u, int v, double dist) {
			this.u = u;
			this.v = v;
			this.dist = dist;
		}
	}
}
