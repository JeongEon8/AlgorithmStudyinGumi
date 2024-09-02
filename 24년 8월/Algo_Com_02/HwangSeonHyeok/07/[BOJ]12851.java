import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static boolean[] visited;

	static int ansTime;
	static int cnt;

	static class Finding {
		int x;
		int time;

		public Finding(int x, int time) {
			this.x = x;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Finding [current=" + x + ", time=" + time + "]";
		}

	}

	static void bfs(int start, int to) {
		Queue<Finding> q = new ArrayDeque<>();
		q.add(new Finding(start, 0));
		while (!q.isEmpty()) {
			Finding current = q.poll();
			visited[current.x] = true;
			if (current.x == to) {
				if (ansTime < current.time) {
					return;
				} else {
					cnt++;
					ansTime = current.time;
				}
			} else {
				if (current.x + 1 <= 140000 && !visited[current.x + 1]) {
					q.add(new Finding(current.x + 1, current.time + 1));
				}
				if (current.x - 1 >= 0 && !visited[current.x - 1]) {
					q.add(new Finding(current.x - 1, current.time + 1));
				}
				if (current.x * 2 <= 140000 && !visited[current.x * 2]) {
					q.add(new Finding(current.x * 2, current.time + 1));
				}
			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		visited = new boolean[200001];
		ansTime = Integer.MAX_VALUE;
		cnt = 0;
		bfs(N, M);
		System.out.println(ansTime);
		System.out.println(cnt);

	}

}