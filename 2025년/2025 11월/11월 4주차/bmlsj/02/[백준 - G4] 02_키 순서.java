import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	static int n, m;
	static List<Integer>[] bigger;
	static List<Integer>[] smaller;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		n = Integer.parseInt(split[0]); // 학생수
		m = Integer.parseInt(split[1]); // 비교 횟수

		smaller = new ArrayList[n + 1];
		bigger = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			smaller[i] = new ArrayList<Integer>();
			bigger[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			split = br.readLine().split(" ");
			int small = Integer.parseInt(split[0]);
			int big = Integer.parseInt(split[1]);

			bigger[small].add(big);
			smaller[big].add(small);
		}

		int result = 0;

		for (int i = 1; i <= n; i++) {
			int big = bfsCount(i, bigger);
			int small = bfsCount(i, smaller);
			
			// System.out.println(big + " " + small);
			if (small + big == n - 1) {
				result++;
			}
		}
		System.out.println(result);
	}

	static int bfsCount(int start, List<Integer>[] g) {
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> q = new ArrayDeque<Integer>();

		q.add(start);
		visited[start] = true;
		int cnt = 0;

		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int next : g[curr]) {
				if (!visited[next]) {
					q.offer(next);
					visited[next] = true;
					cnt++;
				}
			}
		}

		return cnt;
	}
}