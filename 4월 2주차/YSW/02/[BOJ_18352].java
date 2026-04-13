import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		int[] distances = new int[N + 1];
		Queue<Integer> queue = new ArrayDeque<>();
		Arrays.fill(distances, -1);
		distances[X] = 0;
		queue.add(X);

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
		}

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			if (distances[curr] >= K) {
				continue;
			}

			for (int next : list[curr]) {
				if (distances[next] == -1) {
					distances[next] = distances[curr] + 1;
					queue.add(next);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (distances[i] == K) {
				sb.append(i).append("\n");
			}
		}

		System.out.println(sb.length() == 0 ? -1 : sb);
	}
}