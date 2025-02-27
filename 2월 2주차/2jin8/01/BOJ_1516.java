import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1516 {

	static int N;
	static int[] inDegree, times; // inDegree: 진입 차수, times: 건물 짓는데 걸리는 시간
	static ArrayList<Integer>[] graph, reverse;
	static PriorityQueue<Building> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		inDegree = new int[N + 1];
		times = new int[N + 1];
		graph = new ArrayList[N + 1];
		reverse = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			reverse[i] = new ArrayList<>();
		}

		StringTokenizer st = null;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			while (prev != -1) {
				graph[prev].add(i);
				reverse[i].add(prev);
				inDegree[i]++;
				prev = Integer.parseInt(st.nextToken());
			}

			// 진입 차수가 0인 것 큐에 넣기
			if (inDegree[i] == 0) {
				pq.offer(new Building(i, times[i]));
			}
		}

		while (!pq.isEmpty()) {
			int now = pq.poll().idx;

			for (int next : graph[now]) {
				if (--inDegree[next] == 0) {
					times[next] += times[now];
					pq.offer(new Building(next, times[next]));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(times[i]).append("\n");
		}
		System.out.println(sb);
	}

	static class Building implements Comparable<Building> {
		int idx, time;

		public Building(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}

		@Override
		public int compareTo(Building b) {
			return Integer.compare(this.time, b.time);
		}
	}
}
