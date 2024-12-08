import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1719 {

	static int N, M, INF = 1_000_000_000;
	static int[] minDist, path;
	static boolean[] visited;
	static int[][] route;
	static ArrayList<Node>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 집하장의 개수
		M = Integer.parseInt(st.nextToken()); // 경로의 개수

		minDist = new int[N + 1];
		path = new int[N + 1];
		visited = new boolean[N + 1];
		route = new int[N + 1][N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, d));
			graph[b].add(new Node(a, d));
		}

		for (int i = 1; i <= N; i++) {
			Arrays.fill(minDist, INF);
			Arrays.fill(path, 0);
			Arrays.fill(visited, false);

			dijkstra(i);
			for (int j = 1; j <= N; j++) {
				if (i == j) continue;

				int now = j;
				while (true) {
					int next = path[now];
					// 현재 집하장이 가장 먼저 거쳐야 하는 집하장인 경우 
					if (next == path[next]) { 
						route[i][j] = now;
						break;
					}
					now = next;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) sb.append("-").append(" ");
				else sb.append(route[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.d, n2.d));
		pq.offer(new Node(start, 0));
		minDist[start] = 0;
		path[start] = start;

		// 시작점에서 모든 정점까지의 최단거리 구하기
		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (visited[now.x])
				continue;
			visited[now.x] = true;

			for (Node next : graph[now.x]) {
				if (!visited[next.x] && minDist[next.x] > minDist[now.x] + next.d) {
					minDist[next.x] = minDist[now.x] + next.d;
					pq.offer(new Node(next.x, minDist[next.x]));
					path[next.x] = now.x; // 어디서부터 왔는지 경로 기록
				}
			}
		}
	}

	static class Node {
		int x, d;

		public Node(int x, int d) {
			this.x = x;
			this.d = d;
		}
	}
}
