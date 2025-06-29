import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	private static int N, K;
	private static int[] map;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		N = Integer.parseInt(split[0]);
		K = Integer.parseInt(split[1]);

		map = new int[100000 * 2 + 1];
		visited = new boolean[100000 * 2 + 1];
		int ans = 0;
		if (N != K) {
			ans = bfs(N, 1);
		}

		System.out.println(ans);
	}

	public static int[] dx = { -1, 1 };

	public static int bfs(int x, int cnt) {

		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { x, cnt });

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			x = q[0];
			cnt = q[1];

			for (int i = 0; i < 3; i++) {
				int nx = 0;

				if (i == 2)
					nx = x * 2;
				else
					nx = x + dx[i];

				if (nx < 0 || nx > 200000)
					continue;
				if (nx == K)
					return cnt;

				if (!visited[nx]) {
					visited[nx] = true;
					queue.add(new int[] { nx, cnt + 1 });
				}
			}
		}

		return -1;
	}

}