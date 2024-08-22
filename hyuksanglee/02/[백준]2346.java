package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Beakjoon2346 {
	
	

	static class Num{
		public Num(int index, int num) {
			this.index = index;
			this.num = num;
		}
		int index;
		int num;
	}

	public static void main(String args[]) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int [] arr= new int [N];
		Deque<Num>que = new ArrayDeque<Num>();
		
		String[] input = in.readLine().split(" ");
		int idx = 1;
		for (int n = 0; n < N; n++) {
			Num nu = new Num(idx++, Integer.parseInt(input[n]));
			que.offer(nu);
			
		}
		
		int type = 0;
		int num = 0;
		int index =1;
		Num nu = null;
		while(!que.isEmpty()) {
			
			if(type ==0) {
				nu =que.poll();
				num = nu.num;
			}else {
				nu = que.pollLast();
				num = nu.num;
			}
			
			System.out.print(nu.index + " ");
			
			if(que.isEmpty()) {
				break;
			}
			if(num <0) {
				type = 1;
				num = Math.abs(num);
			}else {
				type =0;
			}
			
			for(int i = 0; i<num-1; i++) {
				if(type == 0) {
					que.offer(que.poll());
					
				
				}else {
					que.offerFirst(que.pollLast());
				}
			}
			
		}
		
		
		
		
	}
	
	
}
