package beakjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1665 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> minQ = new PriorityQueue<>();

		// 최대 힙
		PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
		
		
		for(int n = 0; n <N; n++) {
			int num = Integer.parseInt(in.readLine());
			if(maxQ.size()==0) {
				maxQ.add(num);
			}else {
				if(maxQ.peek()>=num) {
					maxQ.add(num);
				}else {
					minQ.add(num);
				}
			}
			
			while(minQ.size()-maxQ.size()<-1) {
				minQ.add(maxQ.poll());
			}
			while(maxQ.size()-minQ.size()<0) {
				maxQ.add(minQ.poll());
			}
			System.out.println(maxQ.peek());
		}

	}

}
