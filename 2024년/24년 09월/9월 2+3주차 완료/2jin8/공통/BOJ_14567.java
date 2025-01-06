import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14567 {

	static int N, M;
	static int[] orders, inDegree; // orders: 수강할 수 있는 학기, inDegree: 진입 차수
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		orders = new int[N + 1];
		inDegree = new int[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			inDegree[b]++; // b의 진입차수(=선수과목 수) 증가
			graph[a].add(b); // 선수과목 정보 저장
		}

		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			// 선수과목이 없으면 큐에 넣기
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		int order = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int now = queue.poll();
				orders[now] = order;

				// 현재 과목과 연결된 과목 끊기 (선수과목 수강했으므로)
				for (int next : graph[now]) {
					if (--inDegree[next] == 0) {
						queue.offer(next);
					}
				}
			}
			order++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(orders[i]).append(" ");
		}
		System.out.println(sb);
	}
}
