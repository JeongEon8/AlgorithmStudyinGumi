import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1240 {

	static int[][] node;
	static int[][] distance;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		node = new int[n + 1][n + 1];
		distance = new int[n + 1][n + 1];

		for (int i = 0; i < n - 1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int l = sc.nextInt();

			node[x][y] = 1;
			node[y][x] = 1;
			distance[x][y] = l;
			distance[y][x] = l;
		}

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			bfs(x, y, n);
		}
	}

	private static void bfs(int start, int end, int n) {

		Queue<Integer> queue = new LinkedList<>();
		visit = new boolean[n + 1];

		visit[start] = true;
		queue.add(start);
		int[] arr = new int[n + 1];

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 1; i <= n; i++) {
				if (node[now][i] == 1 && !visit[i]) {
					arr[i] = arr[now] + distance[now][i];

					if (i == end) {
						System.out.println(arr[end]);
						return;
					}

					queue.add(i);
					visit[i] = true;
				}
			}
		}
	}
}
