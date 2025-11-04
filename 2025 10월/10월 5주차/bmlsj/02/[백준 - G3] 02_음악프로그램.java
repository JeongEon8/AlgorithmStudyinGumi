import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);

		List<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		int[] degree = new int[N + 1]; // 차수
		for (int i = 0; i < M; i++) {

			split = br.readLine().split(" ");
			int k = Integer.parseInt(split[0]);
			int prev = Integer.parseInt(split[1]);
			for (int j = 2; j <= k; j++) {
				int curr = Integer.parseInt(split[j]);
				graph[prev].add(curr);
				degree[curr]++;
				prev = curr;
			}
		}

		// System.out.println(Arrays.toString(degree));

		// 위상 정렬
		Queue<Integer> queue = new ArrayDeque<Integer>();
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i <= N; i++) { // 차수가 0인 노드만 queue에
			if (degree[i] == 0)
				queue.add(i);
		}

		while (!queue.isEmpty()) {

			int cur = queue.poll();
			result.add(cur);

			for (int next : graph[cur]) {
				degree[next]--;
				if (degree[next] == 0) {
					queue.add(next);
				}
			}

		}

		// System.out.println(result);
		if (result.size() - 1 != N) {
			System.out.println(0);
		} else {
			for (int i = 1; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
		}

	}
}