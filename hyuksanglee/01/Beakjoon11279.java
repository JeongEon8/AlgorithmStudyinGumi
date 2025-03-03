package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Beakjoon11279 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
		int N  = Integer.parseInt(in.readLine());
		for(int n = 0; n<N; n++) {
			int x = Integer.parseInt(in.readLine());
			if( x == 0) {
				if(pq.size()<=0) {
					System.out.println(0);
				}else {
					System.out.println(pq.poll());
				}
			}else {
				pq.add(x);
			}
		}
		
	}

}
