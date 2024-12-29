package B_16_중앙값_구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("#");
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 1; t<=T; t++) {
			
			String[] input = in.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int A = Integer.parseInt(input[1]);
			int mid = 0;
			
			PriorityQueue<Integer> queMax = new PriorityQueue<>();
			PriorityQueue<Integer> queMin = new PriorityQueue<>((a,b) -> b - a);
			
			for(int n = 0; n<N; n++) {
				input = in.readLine().split(" ");
				int x = Integer.parseInt(input[0]);
				int y = Integer.parseInt(input[1]);
				
				if(n == 0 ) {
					queMin.add(A);
					queMin.add(x);
					queMin.add(y);
					queMax.add(queMin.poll());
					A = queMin.poll();
				}else {
					if(x<A) {
						queMin.add(x);
						int num = queMin.poll();
						if(queMin.size()>queMax.size()) {
							if(num<A) {
								queMax.add(A);
								A= num;
							}else {
								queMax.add(num);
							}
						}else {
							if(num>A) {
								queMin.add(A);
								A= num;
							}else {
								queMin.add(num);
							}
						}
					}else {
						queMax.add(x);
						int num = queMax.poll();
						if(queMin.size()>queMax.size()) {
							if(num<A) {
								queMax.add(A);
								A= num;
							}else {
								queMax.add(num);
							}
						}else {
							if(num>A) {
								queMin.add(A);
								A= num;
							}else {
								queMin.add(num);
							}
						}
					}	
					
					if(y<A) {
						queMin.add(y);
						int num = queMin.poll();
						if(queMin.size()>queMax.size()) {
							if(num<A) {
								queMax.add(A);
								A= num;
							}else {
								queMax.add(num);
							}
						}else {
							if(num>A) {
								queMin.add(A);
								A= num;
							}else {
								queMin.add(num);
							}
						}
					}else {
						queMax.add(y);
						int num = queMax.poll();
						if(queMin.size()>queMax.size()) {
							if(num<A) {
								queMax.add(A);
								A= num;
							}else {
								queMax.add(num);
							}
						}else {
							if(num>A) {
								queMin.add(A);
								A= num;
							}else {
								queMin.add(num);
							}
						}
					}
				}
				
				mid+=A;
				mid %= 20171109;
			}
			
			System.out.println("#"+t+" "+ mid);
		}

	}

}
