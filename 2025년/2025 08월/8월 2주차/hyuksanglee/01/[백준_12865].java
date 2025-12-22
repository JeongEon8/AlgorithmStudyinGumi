package beakjoon;

import java.io.*;

public class Baekjoon12865 {

	public static void main(String[] args)throws Exception {
		
		BufferedReader in = new BufferedReader ( new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);	// 물품 수
		int K = Integer.parseInt(input[1]);	// 가방 무게
		int[] dp = new int[K+1]; // 가방의 무게 만큼 dp 배열생성
		
		// 입력받을 물품수 만큼 반복
		for (int n = 0; n<N; n++) {
			input = in.readLine().split(" ");
			int W = Integer.parseInt(input[0]); // 물품의 무게
			int V = Integer.parseInt(input[1]);	// 물품의 가치
			
			for(int k = K; k>=W; k--) {
				
				if(dp[k] <= V+dp[k-W]) {
					dp[k] = V+dp[k-W];
				}
			}
			
		}
		
		
		System.out.println(dp[K]);
	}
	
	
	

}
