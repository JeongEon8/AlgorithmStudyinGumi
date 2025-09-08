package beakjoon;

import java.io.*;

public class Baekjoon15486 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));

		// 총 상담 일수 받기
		int N = Integer.parseInt(in.readLine());
		// 날짜별 상담 금액 합
		int[] meet = new int[N+1];
		
		int result = 0;
		
		
		// 일수만큼 반복
		for(int n = 0; n<N; n++) {
			String[] input = in.readLine().split(" ");
			
			// 상담에 걸리는 시간
			int T = Integer.parseInt(input[0]);
			
			// 금액
			int P = Integer.parseInt(input[1]);
			
			// 현재까지 상담금액 최댓값으로 갱신
			if(n>0) {
				if(meet[n-1] > meet[n]) {
					meet[n] = meet[n-1];
				}
			}
			
			// 현재날짜의 최댓금액과 오늘 상담금액 합
			int pay = meet[n]+ P;
			
			// 상담일수가 N보다 초과가 아닐경우
			if(T+n<=N) {
				
				//현재까지 최댓값 갱신
				if(result<pay) {
					result = pay;
				}
				
				//오늘날짜의 상담금액이 지금까지 누적 금액보다 클 경우 갱신
				if(pay > meet[T+n]) {
					meet[T+n] = pay;
				}
				
			}
			
		}
		
		System.out.println(result);
	}

}
