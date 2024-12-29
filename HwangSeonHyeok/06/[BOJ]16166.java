import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Main {
	static class Line {
		Set<Integer> stationSet;

		public Line() {
			this.stationSet = new HashSet<Integer>();
		}

		public int getCnt() {
			return stationSet.size();
		}

		public void add(int station) {
			stationSet.add(station);
		}

		public boolean hasStation(int dest) {
			return stationSet.contains(dest);
		}
	}

	static class Goofcode {
		int line, step;

		public Goofcode(int line, int step) {
			this.line = line;
			this.step = step;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Line[] lines = new Line[n + 1];

		for (int i = 1; i <= n; i++) {
			String[] split = in.readLine().split(" ");
			int k = Integer.parseInt(split[0]);
			lines[i] = new Line();
			for (int j = 1; j <= k; j++) {
				lines[i].add(Integer.parseInt(split[j]));
			}
		}
		int dest = Integer.parseInt(in.readLine());
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			if (lines[i].hasStation(0)) {
				Queue<Goofcode> q = new ArrayDeque<>();
				boolean[] visited = new boolean[n + 1];
				q.add(new Goofcode(i, 0));
				visited[i] = true;
				while (!q.isEmpty()) {
					Goofcode cur = q.poll();
					if (lines[cur.line].hasStation(dest)) {
						ans = Math.min(ans, cur.step);
						break;
					}
					for (int station : lines[cur.line].stationSet) {
						for (int j = 1; j <= n; j++) {
							if (visited[j])
								continue;
							if (lines[j].hasStation(station)) {
								visited[j] = true;
								q.add(new Goofcode(j, cur.step + 1));

							}

						}

					}

				}

			}
		}
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}

	}

}