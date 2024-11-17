import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_9370 {

	static int INF = 1_000_000_000;
	static int[] minDist;
	static boolean[] visited;
	static ArrayList<Node>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 목적지까지 최단거리로 갈 것
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 교차로의 개수
			int m = Integer.parseInt(st.nextToken()); // 도로의 개수
			int t = Integer.parseInt(st.nextToken()); // 목적지 후보의 개수

			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 예술가들의 출발지
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			minDist = new int[n + 1];
			visited = new boolean[n + 1];

			graph = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<Node>();
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// 동일한 최단거리가 있을 때, g - h 사이 간선에 우선순위를 주기
				int d = Integer.parseInt(st.nextToken()) * 2; // 모든 가중치에 * 2
				if ((a == g && b == h) || (a == h && b == g)) {
					// g - h 사이 간선이라면 -1을 해서 우선순위 주기
					d--;
				}
				graph[a].add(new Node(b, d));
				graph[b].add(new Node(a, d));
			}

			ArrayList<Integer> answer = new ArrayList<>();
			for (int i = 0; i < t; i++) {
				Arrays.fill(minDist, INF);
				Arrays.fill(visited, false);

				int end = Integer.parseInt(br.readLine());
				int dist = dijkstra(s, end);
				if (dist == -1) // 목적지까지 이동이 불가능하다면 continue
					continue;

				// 최단거리가 홀수면 g - h 사이 간선을 지나갔다는 뜻
				if (dist % 2 == 1) {
					answer.add(end);
				}
			}

			Collections.sort(answer); // 오름차순 정렬
			for (int a : answer) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.d, n2.d));
		pq.offer(new Node(start, 0));
		minDist[start] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (now.x == end)
				return now.d;

			if (visited[now.x])
				continue;
			visited[now.x] = true;

			for (Node next : graph[now.x]) {
				if (!visited[next.x] && minDist[next.x] > minDist[now.x] + next.d) {
					minDist[next.x] = minDist[now.x] + next.d;
					pq.offer(new Node(next.x, minDist[next.x]));
				}
			}
		}
		return -1;
	}

	static class Node {
		int x, d;

		public Node(int x, int d) {
			this.x = x;
			this.d = d;
		}
	}
}
