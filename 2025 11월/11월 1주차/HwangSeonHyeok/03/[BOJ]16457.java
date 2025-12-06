import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k, ans = 0;
	static int[] quests;

	static void solve(int start, int depth, int mask) {
		if (depth == n) {
			int currentCnt = 0;
			for (int questMask : quests) {
				if ((mask & questMask) == questMask) {
					currentCnt++;
				}
			}
			if (currentCnt > ans) {
				ans = currentCnt;
			}
			return;
		}
		if ((n - depth) > (2 * n - start + 1))
			return;
		for (int i = start; i <= 2 * n; i++) {
			solve(i + 1, depth + 1, mask | (1 << (i - 1)));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		quests = new int[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int questMask = 0;
			for (int j = 0; j < k; j++) {
				int skill = Integer.parseInt(st.nextToken());
				questMask |= (1 << (skill - 1));
			}
			quests[i] = questMask;
		}
		solve(1, 0, 0);
		System.out.println(ans);

	}

}