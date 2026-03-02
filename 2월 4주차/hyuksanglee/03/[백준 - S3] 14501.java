package dp;

import java.io.*;

public class Baekjoon14501 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int result = 0;
		
		int[] dp = new int[N+1];
		for(int n = 0; n<N; n++) {
			String[] input = in.readLine().split(" ");
			int T = Integer.parseInt(input[0]);
			int P = Integer.parseInt(input[1]);
			
			if(T+n<=N  && dp[T+n] < dp[n]+P) {
				dp[T+n] = dp[n]+P;
				if(result< dp[T+n]) {
					result = dp[T+n];
				}
			}
			
			for(int m = T+n+1; m<=N; m++) {
				if(dp[m] < dp[n]+P) {
					dp[m]= dp[n]+P;
				}
				if(result< dp[T+n]) {
					result = dp[T+n];
				}
			}
			
			
		}
		
		System.out.print(result);
		
	}

}
