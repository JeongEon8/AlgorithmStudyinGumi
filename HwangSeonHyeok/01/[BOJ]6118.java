import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

	static List<Integer>[] graph;
	static int n, m, ansNum, ansStep, ansCnt;

	static class JaeSuGi implements Comparable<JaeSuGi> {
		int num, step;

		public JaeSuGi(int num, int step) {
			super();
			this.num = num;
			this.step = step;
		}

		@Override
		public int compareTo(JaeSuGi o) {
			if (this.step < o.step)
				return -1;
			return 1;

		}

	}

	static void solve() {
		PriorityQueue<JaeSuGi> pq = new PriorityQueue<JaeSuGi>();
		pq.add(new JaeSuGi(1, 0));
		boolean[] visited = new boolean[n + 1];
		visited[1] = true;
		ansNum = n + 1;
		while (!pq.isEmpty()) {
			JaeSuGi cur = pq.poll();
			if (cur.step > ansStep) {
				ansStep = cur.step;
				ansCnt = 0;
				ansNum = n + 1;
			}
			ansCnt++;
			if (cur.num < ansNum) {
				ansNum = cur.num;
			}
			for (int next : graph[cur.num]) {
				if (!visited[next]) {
					visited[next] = true;
					pq.add(new JaeSuGi(next, cur.step + 1));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		n = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]);
		graph = new List[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			split = in.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			graph[a].add(b);
			graph[b].add(a);
		}
		solve();
		System.out.println(ansNum + " " + ansStep + " " + ansCnt);

	}

}