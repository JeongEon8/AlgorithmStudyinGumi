package beakjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1744 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 정수 개수를 받는 변수
		int N = Integer.parseInt(in.readLine());
		
		// 2이상 숫자를 담는 우선순위 큐
		PriorityQueue<Integer> plus = new PriorityQueue<>();
		// 음수를 담는 우선순위 큐
		PriorityQueue<Integer> minus = new PriorityQueue<>();
		// 0의 개수를 담는 변수
		int zero = 0;
		// 1의 개수를 담는 변수
		int one =0;
		//결과를 담는 변수
		long result =0;
		
		for(int n =0; n<N; n++) {
			int num = Integer.parseInt(in.readLine());
			if(num==1) {
				one++;
			}else if(num==0 ) {
				zero++;
			}else if(num>1) {
				plus.add(num);
			}else {
				minus.add(num);
			}
		}
		
		// 우선순위 큐에는 작은 순부터이므로 홀수이면 작은수를 더해준다.
		if(plus.size()%2 == 1) {
			result +=plus.poll();
		}
		
		// 나머지 2이상 값들을 2개씩 곱해준다.
		while(!plus.isEmpty()) {
			int sum = 0;
		
			sum = plus.poll() * plus.poll();
			
			result += sum;
		}
		
		
		while(!minus.isEmpty()) {
			
			// 음수끼리 곱하면 양수가 되므로 2개씩 곱해준다.
			if(minus.size()>1) {
				result += minus.poll() * minus.poll();
			}else {
				// 한개 남았을때는 0이 있으면 곱해서 상쇄시켜주고 아니면 결과값에 더해준다.
				if(zero>0) {
					zero--;
					minus.poll();
				}else {
					result+= minus.poll();
				}
			}
		
		}
		
		// 1의 개수 만큼 결과값에 더해준다.
		result += one;
		
		
		
		
		System.out.println(result);
	}
	
	

}
