package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1744_2 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 정수 개수를 받는 변수
		int N = Integer.parseInt(in.readLine());
		int[] number = new int[N];
		
		for(int n =0; n<N; n++) {
			int num = Integer.parseInt(in.readLine());
			number[n] = num;
		}
		
		Arrays.sort(number);
		
		int[][]dp = new int[2][N+1];
		
		for(int i =0; i<N; i++) {
			if(i==0) {
				dp[0][1] =number[i];
				dp[1][1] =number[i];
			}else if(i == 1){
				dp[0][2] = number[i]+dp[0][1];
				dp[1][2] = number[i]*dp[0][1];
			}else {
				int max = dp[1][i];
				if(dp[0][i]> dp[1][i]) {
					max = dp[0][i];
				}
				dp[0][i+1] = number[i] +max;
				
				max = dp[1][i-1];
				if(dp[0][i-1]> dp[1][i-1]) {
					max = dp[0][i-1];
				}
				
				dp[1][i+1] = number[i]*number[i-1] +max;
			}
		}
		
		int result = dp[0][N];
		if(result< dp[1][N]) {
			result = dp[1][N];
		}
		
		System.out.println(result);

	}

}
