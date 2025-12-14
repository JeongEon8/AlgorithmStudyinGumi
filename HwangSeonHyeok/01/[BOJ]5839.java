import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] infoA = new int[n][2];
		int[][] infoB = new int[m][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			infoA[i][0] = Integer.parseInt(st.nextToken());
			infoA[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			infoB[i][0] = Integer.parseInt(st.nextToken());
			infoB[i][1] = Integer.parseInt(st.nextToken());
		}
		int aIdx = 0;
		int bIdx = 0;
		long distA = 0;
		long distB = 0;
		int faster = 0;
		int ans = 0;
		int aRemain = infoA[0][1];
		int bRemain = infoB[0][1];
		while (aIdx < n && bIdx < m) {
			int currentTime = Math.min(aRemain, bRemain);
			distA += infoA[aIdx][0] * currentTime;
			distB += infoB[bIdx][0] * currentTime;

			aRemain -= currentTime;
			bRemain -= currentTime;

			if (distA > distB) {
				if (faster == 2) {
					ans++;
					faster = 1;
				} else if (faster == 0) {
					faster = 1;
				}
			} else if (distB > distA) {
				if (faster == 1) {
					ans++;
					faster = 2;
				} else if (faster == 0) {
					faster = 2;
				}
			}

			if (aRemain == 0) {
				aIdx++;
				if (aIdx < n) {
					aRemain = infoA[aIdx][1];
				}
			}

			if (bRemain == 0) {
				bIdx++;
				if (bIdx < m) {
					bRemain = infoB[bIdx][1];
				}
			}

		}

		System.out.println(ans);

	}

}