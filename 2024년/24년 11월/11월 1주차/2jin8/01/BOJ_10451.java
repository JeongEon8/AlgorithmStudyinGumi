import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10451 {

	static int N, cycle;
	static int[] arr;
	static boolean[] done, visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N + 1];
			done = new boolean[N + 1];
			visited = new boolean[N + 1];
			cycle = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (arr[i] == i) {
					done[i] = true;
					cycle++;
				}
			}

			for (int i = 1; i <= N; i++) {
				if (!done[i])
					dfs(i);
			}
			sb.append(cycle).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int x) {
		// 탐색 완료된 곳이면 종료
		if (done[x]) return;
		// 탐색이 완료되지 않았지만 이미 방문한 곳 ⇒ 사이클 발생
		if (visited[x]) {
			cycle++;
			done[x] = true; // 탐색완료 처리
			visited[x] = false; // 방문처리 취소
			return;
		}

		visited[x] = true;
		dfs(arr[x]);
		visited[x] = false;
		done[x] = true;
	}
}
