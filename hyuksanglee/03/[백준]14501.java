package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon14501 {


	public static void main(String[] args)throws Exception {
		
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// TODO Auto-generated method stub
		 
		 int N =Integer.parseInt(in.readLine());

		 int[] dp = new int[N+1]; 
		 int max =0;
		 
		 for (int n =0; n<N; n++) {
			 String[] input =in.readLine().split(" ");
		 
			int day = Integer.parseInt(input[0]);
			 int price = Integer.parseInt(input[1]);
			 
			// 현재까지의 최대 수익을 갱신
	            if (max < dp[n]) {
	                max = dp[n];
	            }
	            
	         // n + day일에 상담이 끝나는 경우
	            if (n + day <= N) {
	                dp[n + day] = Math.max(dp[n + day], max + price);
	            }
		 }
		 // 마지막 날까지의 최대 수익 출력
	        for (int i = 0; i <= N; i++) {
	            if (max < dp[i]) {
	                max = dp[i];
	            }
	        }
		 
		 System.out.println(max);
		 
		 

	}

}
