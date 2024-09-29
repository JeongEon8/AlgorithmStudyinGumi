import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	static class Route implements Comparable<Route> {
		int from, to, cost;
		List<Integer> route;

		public Route(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
			this.route = new ArrayList<>();
			route.add(from);
			if (from != to)
				route.add(to);
		}

		public Route(Route from, Route to) {
			super();
			this.from = from.from;
			this.to = to.to;
			this.cost = from.cost + to.cost;
			route = new ArrayList<Integer>();
			route.addAll(from.route);
			route.add(this.to);
		}

		@Override
		public int compareTo(Route o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		List<Route>[] eList = new ArrayList[n + 1];
		String[] split;
		for (int i = 1; i <= n; i++) {
			eList[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			split = in.readLine().split(" ");
			int from = Integer.parseInt(split[0]);
			int to = Integer.parseInt(split[1]);
			int cost = Integer.parseInt(split[2]);
			eList[from].add(new Route(from, to, cost));
		}
		split = in.readLine().split(" ");
		int start = Integer.parseInt(split[0]);
		int dest = Integer.parseInt(split[1]);
		Route[] minRoute = new Route[n + 1];
		for (int i = 1; i <= n; i++) {
			minRoute[i] = new Route(start, i, Integer.MAX_VALUE);
		}
		minRoute[start] = new Route(start, start, 0);
		PriorityQueue<Route> pq = new PriorityQueue<>();
		pq.add(minRoute[start]);
		while (!pq.isEmpty()) {
			Route r = pq.poll();
			if (r.cost > minRoute[r.to].cost)
				continue;
			for (Route next : eList[r.to]) {
				if (r.cost + next.cost < minRoute[next.to].cost) {
					minRoute[next.to] = new Route(r, next);
					pq.add(minRoute[next.to]);
				}
			}
		}
		sb.append(minRoute[dest].cost + "\n");
		sb.append(minRoute[dest].route.size() + "\n");
		for (int v : minRoute[dest].route) {
			sb.append(v + " ");
		}
		System.out.println(sb);
	}

}