import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BOJ_1058 {

	static int N;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				// 연결되어 있으면 그래프 정보에 추가
				if (str.charAt(j) == 'Y')
					graph[i].add(j);
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, bfs(i));
		}
		System.out.println(max);
	}

	static int bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N];
		visited[start] = true;
		queue.offer(start);

		int friend = 0, depth = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int now = queue.poll();
				friend++;

				for (int next : graph[now]) {
					if (!visited[next]) {
						queue.offer(next);
						visited[next] = true;
					}
				}
			}
			// 깊이가 2 이하인 친구들의 수만 세면 됨
			if (depth++ == 2)
				break;
		}
		return friend - 1; // 자기 자신은 제외
	}
}
