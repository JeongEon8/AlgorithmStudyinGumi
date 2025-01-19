import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1766 {

	static int N, M;
	static int[] degree;
	static boolean[] solved;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		degree = new int[N + 1];
		solved = new boolean[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) { // a번 문제는 b번 문제보다 먼저 푸는 것이 좋음
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			degree[b]++; // 진입차수 증가
			graph[a].add(b);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			// 진입 차수가 0인 문제 번호 넣기
			if (degree[i] == 0) {
				pq.offer(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			int now = pq.poll();
			sb.append(now).append(" ");
			
			for (int next : graph[now]) {
				if (--degree[next] == 0) { // 진입차수 1개씩 줄이기 & 0이되면 큐에 넣기
					pq.offer(next);
				}
			}
		}
		System.out.println(sb);
	}
}
