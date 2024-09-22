import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1005 {

	static int N, K;
	static int[] inDegree, times, delay;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			delay = new int[N + 1];
			times = new int[N + 1];
			inDegree = new int[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				times[i] = Integer.parseInt(st.nextToken());
			}

			graph = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				// 건설 순서: a -> b
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				inDegree[b]++; // 진입 차수 증가
				graph[a].add(b); // 건설 순서 저장
			}

			int target = Integer.parseInt(br.readLine());

			Queue<Integer> queue = new ArrayDeque<>();
			for (int i = 1; i <= N; i++) {
				// 진입 차수가 0인 건물 큐에 넣기
				if (inDegree[i] == 0) {
					queue.offer(i);
					delay[i] = times[i];
				}
			}

			while (!queue.isEmpty()) {
				int now = queue.poll();
				if (now == target)
					break;

				for (int next : graph[now]) {
					// next 건물을 짓기 전까지 소요되는 최대 시간 구하기
					// 선수 건물들이 다 지어질 때까지 기다려야 하므로 최대 시간을 구해야 함
					delay[next] = Math.max(delay[next], delay[now] + times[next]);

					// 진입차수가 0이 되면 큐에 넣기
					if (--inDegree[next] == 0) {
						queue.offer(next);
					}
				}
			}
			sb.append(delay[target]).append("\n");
		}
		System.out.println(sb);
	}
}
