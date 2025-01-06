import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11779 {

	static int N, M, INF = 100_000_000;
	static int[] minDist, route;
	static boolean[] visited;
	static ArrayList<City>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		minDist = new int[N + 1];
		route = new int[N + 1];
		visited = new boolean[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<City>();
		}

		StringTokenizer st = null;
		// A 도시에서 B 도시까지 가는데 드는 최소 비용 & 경로
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new City(b, c));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		int dist = dijkstra(start, end);
		int check = end, cnt = 0;
		while (true) {
			sb.insert(0, check + " ");

			cnt++;
			if (check == route[check])
				break;
			check = route[check];
		}
		System.out.println(dist);
		System.out.println(cnt);
		System.out.println(sb);
	}

	static int dijkstra(int start, int end) {
		PriorityQueue<City> pq = new PriorityQueue<>((c1, c2) -> Integer.compare(c1.d, c2.d));
		pq.offer(new City(start, 0));
		Arrays.fill(minDist, INF);
		minDist[start] = 0;
		route[start] = start;

		while (!pq.isEmpty()) {
			City now = pq.poll();

			if (visited[now.x])
				continue;
			visited[now.x] = true;
			if (now.x == end)
				break;

			for (City next : graph[now.x]) {
				if (!visited[next.x] && minDist[next.x] > next.d + minDist[now.x]) {
					minDist[next.x] = next.d + minDist[now.x];
					pq.offer(new City(next.x, minDist[next.x]));
					route[next.x] = now.x;
				}
			}
		}
		return minDist[end]; // 항상 시작점에서 도착점까지의 경로가 존재함
	}

	static class City {
		int x, d;

		public City(int x, int d) {
			this.x = x;
			this.d = d;
		}
	}
}
