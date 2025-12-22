
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

	static int K, V, E;
	static int[] colors;
	static List<Integer>[] graph;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < K; tc++) {
			String[] split = br.readLine().split(" ");
			V = Integer.parseInt(split[0]); // 정점
			E = Integer.parseInt(split[1]); // 간선

			graph = new ArrayList[V + 1];
			colors = new int[V + 1];

			for (int i = 0; i <= V; i++) {
				graph[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < E; i++) {
				split = br.readLine().split(" ");
				int a = Integer.parseInt(split[0]);
				int b = Integer.parseInt(split[1]);

				graph[a].add(b);
				graph[b].add(a);
			}

			String ans = "YES";
			for (int i = 1; i <= V; i++) {
				if (colors[i] == 0) {
					if (!bfs(i)) {
						ans = "NO";
						break;
					}
				}
			}

			System.out.println(ans);
		}

	}

	static boolean bfs(int start) {

		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(start);
		colors[start] = 1; // 시작은 빨간색 1

		while (!queue.isEmpty()) {

			int v = queue.poll();

			for (int nv : graph[v]) {

				if (colors[nv] == colors[v])
					return false;

				if (colors[nv] == 0) {
					colors[nv] = -colors[v]; // 인접은 -1
					queue.add(nv);
				}
			}
		}

		return true;

	}

}