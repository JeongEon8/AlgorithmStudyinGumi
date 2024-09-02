import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2623 {
	static int N, M;
	static int[] degrees, order;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		degrees = new int[N + 1]; // 진입 차수

		graph = new ArrayList[N + 1]; // 연결 정보
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			for (int j = 1; j < K; j++) {
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				degrees[b]++;
				a = b;
			}
		}

		order = new int[N]; // 정렬 결과
		StringBuilder sb = new StringBuilder();
		if (sorting()) {
			for (int o : order) {
				sb.append(o).append("\n");
			}
			System.out.println(sb);
		} else {
			System.out.println(0);
		}
	}

	static boolean sorting() {
		Queue<Integer> queue = new ArrayDeque<>();
		// 진입 차수가 0
		for (int i = 1; i <= N; i++) {
			if (degrees[i] == 0) {
				queue.offer(i);
			}
		}

		int idx = 0;
		while (!queue.isEmpty()) {
			int now = queue.poll(); // 진입 차수가 0인 것만 나옴
			order[idx++] = now;

			for (int next : graph[now]) {
				if (--degrees[next] == 0) {
					queue.offer(next);
				}
			}
		}
		// 저장된 값이 N개가 아니면 위상정렬 실패 (사이클)
		return idx == N ? true : false;
	}
}
