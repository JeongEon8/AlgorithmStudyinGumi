package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon13975 {
	

	public static void main(String[] args)throws Exception {
		
		// 입력 받기 위해 BufferedReader 객체 생성
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트할 테스트 수 입력 받기
		int T = Integer.parseInt(in.readLine());
		
		// T만큼 반복 처리
		for (int t = 0; t<T; t++) {
			
			// 소설을 구성하는 장의 수 입력 받
			int K = Integer.parseInt(in.readLine());
			String[] input = in.readLine().split(" ");
			
			// 우선순위 큐 선언
			PriorityQueue<Long> que = new PriorityQueue<>();
			
			long sum = 0;
			
			for(int k = 0; k<K; k++) {
				
				que.add(Long.parseLong(input[k]));
				
			}
			
			while(que.size()>1) {
				long a = que.poll();
				long b = que.poll();
				long total = a+b;
				sum += total;
				que.add(total);
			}
			
			System.out.println(sum);
			
			/**
			 *	 int[] data = Arrays.stream(in.readLine().split(" "))	
             *      .mapToInt(Integer::parseInt)
             *      .toArray();
			 */
			
			
		}

	}

}
