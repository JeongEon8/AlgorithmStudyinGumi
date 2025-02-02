import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14496 {

	static int A, B, N, M;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 전체 문자의 수
		M = Integer.parseInt(st.nextToken()); // 치환 가능한 문자쌍의 수
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		// a를 b로 치환 == b를 a로 치환 => 양방향
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		System.out.println(bfs());
	}

	static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[] used = new boolean[N + 1];
		queue.offer(new int[] { A, 0 });
		used[A] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int num = now[0], count = now[1]; // num: 문자, count: 치환 횟수
			if (num == B)
				return count;

			for (int next : graph[num]) {
				if (!used[next]) {
					queue.offer(new int[] { next, count + 1 });
					used[next] = true;
				}
			}
		}
		return -1;
	}
}
