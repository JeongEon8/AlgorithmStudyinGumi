import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697 {

	static int n, k;
	static int[] visited = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt();

		int result = bfs(n);
		
		System.out.println(result);
	}

	private static int bfs(int node) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(node);
		int index = node;
		visited[index] = 1;

		while (!queue.isEmpty()) {
			int now = queue.remove();

			if (now == k) {
				return visited[now] - 1;
			}

			if (now - 1 >= 0 && visited[now - 1] == 0) {
				visited[now - 1] = visited[now] + 1;
				queue.add(now - 1);
			}

			if (now + 1 <= 100000 && visited[now + 1] == 0) {
				visited[now + 1] = visited[now] + 1;
				queue.add(now + 1);
			}

			if (now * 2 <= 100000 && visited[now * 2] == 0) {
				visited[now*2] = visited[now]+1;
				queue.add(now*2);
			}

		}

		return -1;
	}

}
