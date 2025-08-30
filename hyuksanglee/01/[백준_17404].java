package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon17404 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int cost[][] = new int[N][3];
		
		int result = Integer.MAX_VALUE;
		
		for(int n = 0; n<N; n++) {
			String[] input = in.readLine().split(" ");
	
			for(int i =0; i<3; i++) {
				cost[n][i] = Integer.parseInt(input[i]);
			}
			
		}
		
		
		for(int start = 0; start<3; start++) {
			int[][] dp = new int[N][3];
			for(int n=0; n<N; n++) {
				if(n ==0) {
					for(int j =0; j<3; j++) {
						if(j==start) {
							dp[n][j] = cost[n][j];
						}else {
							
							dp[n][j] = Integer.MAX_VALUE;
						}
						
					}
					
				}else {
					for(int i =0; i<3; i++) {
						int max = Integer.MAX_VALUE;
						for(int j = 0; j<3; j++) {
							if(j != i) {
								if(max>dp[n-1][j]) {
									max = dp[n-1][j];
								}
								
							}
						}
						if(max == Integer.MAX_VALUE) {
							dp[n][i] = max;
						}else {
							dp[n][i] = cost[n][i] + max;
						}
						
					}
					
				}
				
			}
			
			for(int i =0; i<3; i++) {
				if(i != start) {
					if(result>dp[N-1][i]) {
						result = dp[N-1][i];
					}
				}
				
				
				
			}
			
		}
		
		System.out.println(result);
		
		
	}

}
