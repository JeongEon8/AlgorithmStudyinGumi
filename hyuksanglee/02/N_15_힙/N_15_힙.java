package N_15_힙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class N_15_힙 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int t =1; t<=T; t++) {
			System.out.print("#"+t);
			int N = Integer.parseInt(in.readLine());
			PriorityQueue<Integer> que = new PriorityQueue<>((a,b) -> b - a);
			
			for(int n =0; n<N; n++) {
				String[] input = in.readLine().split(" ");
				int type = Integer.parseInt(input[0]);
				if(type == 1) {
					que.add(Integer.parseInt(input[1]));
				}
				else if(type ==2) {
					int result = -1;
					if(!que.isEmpty()) {
						result = que.poll();
					}
					
					System.out.print(" "+result);
				}
				
				
			}
			System.out.println();
		}
		
		
	}

}
