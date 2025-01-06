import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_5972 {

	static int N, M, INF = 1_000_000_000;
	static int[] minDist;
	static boolean[] visited;
	static ArrayList<Pos>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 다익스트라
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		minDist = new int[N + 1];

		visited = new boolean[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Pos>();
		}

		// 1에서 N까지 최단 거리로 이동해야 함
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Pos(b, c));
			graph[b].add(new Pos(a, c));
		}
		System.out.println(dijkstra(1));
	}

	static int dijkstra(int x) {
		PriorityQueue<Pos> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.d, p2.d));
		pq.offer(new Pos(x, 0));
		Arrays.fill(minDist, INF);
		minDist[x] = 0;

		while (!pq.isEmpty()) {
			Pos now = pq.poll();

			// 이미 방문했다면 넘어가기
			if (visited[now.x])
				continue;

			visited[now.x] = true;
			if (now.x == N)
				return minDist[N];

			for (Pos next : graph[now.x]) {
				// 현재 통로를 거치는 것이 더 여물을 적게 주는 경우
				if (!visited[next.x] && minDist[next.x] > next.d + minDist[now.x]) {
					minDist[next.x] = next.d + minDist[now.x];
					pq.offer(new Pos(next.x, minDist[next.x]));
				}
			}
		}
		return -1;
	}

	static class Pos {
		int x, d;

		public Pos(int x, int d) {
			this.x = x;
			this.d = d;
		}
	}
}
