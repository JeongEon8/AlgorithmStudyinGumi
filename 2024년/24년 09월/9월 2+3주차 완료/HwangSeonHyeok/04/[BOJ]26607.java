import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);
		int x = Integer.parseInt(split[2]);
		int[] pow = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			split = in.readLine().split(" ");
			pow[i] = Integer.parseInt(split[0]);

		}
		int max = k * x;
		int[][] dp = new int[k + 1][max + 1];
		for(int i = 0;i<=k;i++) {
			for(int j = 0; j<=max;j++) {
				dp[i][j] = -1; 
			}
		}
		dp[0][0] = 0;
		for (int idx = 1; idx <= n; idx++) {
			int p = pow[idx];
			int imax = idx<k ? idx:k;
			for (int i = 1; i <= imax; i++) {
				for (int j = 0; j <= max; j++) {
					if (j >= p && dp[i - 1][j - p]!=-1&&dp[i - 1][j - p]!=idx) {
						if(dp[i][j]==-1) {
							dp[i][j]=idx;
						}
					}
				}
			}
		}

		int ans = Integer.MIN_VALUE;
		for (int i = 0; i <= max; i++) {
			if (dp[k][i]>0) {
				int sum = i * (max - i);
				if (sum > ans) {
					ans = sum;
				}
			}
		}
		System.out.println(ans);

	}

}