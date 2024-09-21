import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889 {

	static int N, ans;
	static int[][] arr;
	static boolean[] used;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		arr = new int[N][N];
		used = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// n C n/2
		ans = Integer.MAX_VALUE;
		dfs(0, 0);
		System.out.println(ans);
	}

	static void dfs(int depth, int start) {
		if (depth == N / 2) {
			int startScore = 0, linkScore = 0;
			// 스타트 팀의 능력치 구하기 (used[i]가 true)
			for (int i = 0; i < N - 1; i++) {
				if (!used[i]) continue;
				for (int j = i + 1; j < N; j++) {
					if (!used[j]) continue;
					startScore += arr[i][j] + arr[j][i];
				}
			}

			// 링크 팀의 능력치 구하기 (used[i]가 false)
			for (int i = 0; i < N - 1; i++) {
				if (used[i]) continue;
				for (int j = i + 1; j < N; j++) {
					if (used[j]) continue;
					linkScore += arr[i][j] + arr[j][i];
				}
			}
			ans = Math.min(ans, Math.abs(startScore - linkScore));
			return;
		}

		for (int i = start; i < N; i++) {
			if (used[i])
				continue;

			used[i] = true;
			dfs(depth + 1, i);
			used[i] = false;
		}
	}
}
