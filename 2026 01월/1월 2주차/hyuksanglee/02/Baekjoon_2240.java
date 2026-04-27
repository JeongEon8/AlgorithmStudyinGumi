package dp;

import java.io.*;

public class Baekjoon_2240 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		
		int T = Integer.parseInt(input[0]);
		
		int W = Integer.parseInt(input[1]);
		
		int[][] dp = new int[T][W + 1];
		
		for(int t = 0; t<T; t++) {
			int tree = Integer.parseInt(in.readLine());
			if(t==0) {
				if (tree == 1) {
                    dp[0][0] = 1;
                    if (W > 0) dp[0][1] = 0; 
                } else {
                    dp[0][0] = 0;
                    if (W > 0) dp[0][1] = 1; 
                }
			}else {
				for(int i = 0; i<=W; i++) {
					
					int type = (i % 2 == 0) ? 1 : 2;
					
					int max = dp[t-1][i];
					
					if(i>0 && dp[t-1][i-1]>max) {
						max= dp[t-1][i-1];
					}
					
					dp[t][i] = max;
					if(type == tree) {
						dp[t][i] += 1;
					}
				}
			}
			
		}
		int max = 0;
		for(int w = 0 ; w<=W; w++) {
			if(dp[T-1][w] >max ) {
				max = dp[T-1][w];
			}
		}
		
		System.out.println(max);
	}

}
