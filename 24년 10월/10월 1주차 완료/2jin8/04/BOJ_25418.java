import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_25418 {

	static final int MAX = 1_000_001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		bfs(A, K);
	}

	static void bfs(int A, int K) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { A, 0 });
		boolean[] visited = new boolean[MAX];
		visited[A] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if (now[0] == K) {
				System.out.println(now[1]);
				break;
			}

			int next = now[0] + 1;
			if (next < MAX && !visited[next]) {
				queue.offer(new int[] { next, now[1] + 1 });
				visited[next] = true;
			}

			next = now[0] * 2;
			if (next < MAX && !visited[next]) {
				queue.offer(new int[] { next, now[1] + 1 });
				visited[next] = true;
			}
		}
	}
}
