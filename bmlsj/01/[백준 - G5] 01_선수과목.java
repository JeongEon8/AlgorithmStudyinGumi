import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M;
	static List<Integer>[] subjects;
	static int[] ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		subjects = new ArrayList[N + 1];
		int[] indegree = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			subjects[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			subjects[a].add(b);
			indegree[b]++; // 간선 증가
		}

		ans = new int[N + 1];
		bfs(indegree);
		for (int i = 1; i <= N; i++) {
			System.out.print(ans[i] + " ");
		}

	}

	static void bfs(int[] indegree) {

		Queue<Integer> q = new ArrayDeque<Integer>();

		// 1. 진입 차수 0
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.add(i);
				ans[i] = 1;
			}
		}

		// 연결 노드 진입 차수 감소
		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : subjects[cur]) {
				indegree[next]--;

				ans[next] = Math.max(ans[next], ans[cur] + 1);
				if (indegree[next] == 0) {
					q.add(next);
				}

			}
		}
	}

}