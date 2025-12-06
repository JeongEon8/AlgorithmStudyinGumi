package dp;

import java.io.*;

public class Beakjoon2579 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[][]dp = new int[n][2];
		
		for(int i = 0; i<n; i++) {
			int max = 0;
			int p = Integer.parseInt(in.readLine());
			if(i == 0) {
				dp[i][0] = p;
				dp[i][1] = p;
			}
			else if(i==1) {
				dp[i][0] = p;
				dp[i][1] = p+dp[0][0];
			}
			else {
				if(max < dp[i-2][0]) {
					max = dp[i-2][0];
				}
				if(max < dp[i-2][1]) {
					max = dp[i-2][1];
				}
				dp[i][0] = max + p;
				dp[i][1] = dp[i-1][0] + p;
			}
				
			
		}
		
		int max = 0;
		if(dp[n-1][0]>max) {
			max=dp[n-1][0];
		}
		if(dp[n-1][1]>max) {
			max = dp[n-1][1];
		}
		
		System.out.print(max);
	}

}
