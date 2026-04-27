package 큐;

import java.io.*;
import java.util.*;

public class Baekjoon1021 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		Deque<Integer>que = new ArrayDeque<Integer>();
		for(int n = 1; n<=N; n++) {
			que.add(n);
		}
		
		input = in.readLine().split(" ");
		int total =0;
		for(int m = 0; m< M; m++) {
			int n = Integer.parseInt(input[m]);
			int index = 0;
			for(int num : que) {
				if(num == n) {
					break;
				}
				index++;
			}
			if(index > que.size()/2) {
				while(que.peek()!=n) {
					int q = que.pollLast();
					que.addFirst(q);
					total++;
				}
				que.poll();
			}else {
				while(que.peek()!=n) {
					int q = que.pollFirst();
					que.add(q);
					total++;
				}
				que.poll();
			}
		}
		
		System.out.print(total);

	}

}
