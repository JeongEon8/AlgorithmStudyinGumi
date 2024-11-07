import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 {

	static int N, E, INF = Integer.MAX_VALUE;
	static ArrayList<Node>[] edges;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edges = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<Node>();
		}

		// 간선 정보 저장
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[u].add(new Node(v, w));
			edges[v].add(new Node(u, w));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		int c1 = dijkstra(1, v1);
		int c2 = dijkstra(v1, v2);
		int c3 = dijkstra(v2, N);
		int cost1 = INF, cost2 = INF;
		if (c1 == -1 || c2 == -1 || c3 == -1)
			cost1 = -1;
		else
			cost1 = c1 + c2 + c3;

		c1 = dijkstra(1, v2);
		c2 = dijkstra(v2, v1);
		c3 = dijkstra(v1, N);
		if (c1 == -1 || c2 == -1 || c3 == -1)
			cost2 = -1;
		else
			cost2 = c1 + c2 + c3;

		if (cost1 == -1 && cost2 == -1)
			System.out.println(-1);
		else if (cost1 == -1)
			System.out.println(cost2);
		else if (cost2 == -1)
			System.out.println(cost1);
		else
			System.out.println(Math.min(cost1, cost2));

	}

	static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.w, n2.w));
		pq.offer(new Node(start, 0));
		int[] minDist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(minDist, INF);
		minDist[start] = 0;
		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (visited[now.u])
				continue;
			visited[now.u] = true;

			if (now.u == end)
				return now.w;

			for (Node next : edges[now.u]) {
				if (!visited[next.u] && minDist[next.u] > minDist[now.u] + next.w) {
					minDist[next.u] = minDist[now.u] + next.w;
					pq.offer(new Node(next.u, minDist[next.u]));
				}
			}
		}
		return -1;
	}

	static class Node {
		int u, w;

		public Node(int u, int w) {
			this.u = u;
			this.w = w;
		}
	}
}
