import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

	private static int N, M;
	private static List<Integer>[] friend;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);

		friend = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			friend[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			split = br.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);

			friend[a].add(b);
			friend[b].add(a);

		}

		int min = Integer.MAX_VALUE;
		int idx = 0;

		for (int i = 1; i <= N; i++) {
			int bacon = 0;
			for (int target = 1; target <= N; target++) {
				if (target != i) {
					visited = new boolean[N + 1];
					bacon += connect(i, target);
				}
			}

			if (min > bacon) {
				min = bacon;
				idx = i;
			}
		}
		System.out.println(idx);

	}

	public static int connect(int x, int target) {

		Queue<int[]> queue = new ArrayDeque<int[]>();
		visited[x] = true;
		queue.add(new int[] { x, 0 });

		while (!queue.isEmpty()) {

			int[] q = queue.poll();
			x = q[0];
			int dis = q[1];

			for (int nx : friend[x]) {

				if (nx == target) {
					return dis;
				}

				if (!visited[nx]) {
					visited[nx] = true;
					queue.add(new int[] { nx, dis + 1 });
				}
			}

		}

		return -1;
	}

}