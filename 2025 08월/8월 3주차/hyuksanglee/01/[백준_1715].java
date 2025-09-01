package beakjoon;
import java.io.*;
import java.util.*;

public class Baekjoon1715 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader( System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		PriorityQueue<Integer> que = new PriorityQueue();
		
		
		for(int n = 0; n<N; n++) {
			int num = Integer.parseInt(in.readLine());
			que.offer(num);
		}
		
		int total = 0;
		
		while(que.size() > 1) {
			int num = que.poll() + que.poll();
			total += num;
			
			que.add(num);
		}
		System.out.println(total);
		
		
	}

}
