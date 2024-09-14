import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1238 {

	static int N, M, X, INF = Integer.MAX_VALUE;
	static int[] dist[], d;
	static boolean[] visited;
	static ArrayList<Node>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken()); // 도착지

		d = new int[N + 1];
		visited = new boolean[N + 1];
		dist = new int[N + 1][N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v, d));
		}

		// 각 정점에서 모든 정점까지 소요 시간 구하기
		for (int i = 1; i <= N; i++) {
			dist[i] = dijkstra(i).clone();
		}

		int maxTime = 0;
		for (int i = 1; i <= N; i++) {
			if (i == X)
				continue;
			int time = dist[i][X] + dist[X][i];
			if (time > maxTime)
				maxTime = time;
		}
		System.out.println(maxTime);
	}

	static int[] dijkstra(int x) {
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.dist, n2.dist));
		Arrays.fill(d, INF);
		Arrays.fill(visited, false);

		pq.offer(new Node(x, 0));
		d[x] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (visited[now.x])
				continue;
			visited[now.x] = true;

			for (Node next : graph[now.x]) {
				if (visited[next.x]) continue;
				
				if (d[next.x] > d[now.x] + next.dist) {
					d[next.x] = d[now.x] + next.dist;
					pq.offer(new Node(next.x, d[next.x]));
				}
			}
		}
		return d;
	}

	static class Node {
		int x, dist;

		public Node(int x, int dist) {
			this.x = x;
			this.dist = dist;
		}
	}
}
