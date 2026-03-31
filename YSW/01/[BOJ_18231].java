import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_18231 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] towns = new ArrayList[N + 1];
		boolean[] isDestroyed = new boolean[N + 1];
		boolean[] expected = new boolean[N + 1];
		ArrayList<Integer> bombTargets = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			towns[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			towns[u].add(v);
			towns[v].add(u);
		}

		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int d = Integer.parseInt(st.nextToken());
			isDestroyed[d] = true;
		}

		for (int i = 1; i <= N; i++) {
			if (!isDestroyed[i]) {
				continue;
			}

			boolean canDrop = true;
			for (int neighbor : towns[i]) {
				if (!isDestroyed[neighbor]) {
					canDrop = false;
					break;
				}
			}

			if (canDrop) {
				bombTargets.add(i);
			}
		}

		for (int target : bombTargets) {
			expected[target] = true;
			for (int neighbor : towns[target]) {
				expected[neighbor] = true;
			}
		}

		boolean possible = true;
		for (int i = 1; i <= N; i++) {
			if (expected[i] != isDestroyed[i]) {
				possible = false;
				break;
			}
		}

		if (possible && !bombTargets.isEmpty()) {
			System.out.println(bombTargets.size());
			for (int target : bombTargets) {
				sb.append(target).append(" ");
			}
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
	}
}