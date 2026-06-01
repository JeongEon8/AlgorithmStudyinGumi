package 고득점Kit;

import java.util.PriorityQueue;

public class Programmers_더맵게 {

	 public int solution(int[] scoville, int K) {
	        int answer = 0;
	        PriorityQueue<Integer> que = new PriorityQueue<>();
	        for(int i : scoville){
	            que.add(i);
	        }
	        
	        int total = 0;
	        
	        while(que.size()>=2 && que.peek()<K){
	            int f = que.poll();
	            int s = que.poll();
	            total = f + s*2;
	            que.add(total);
	            answer++;
	        }
	        
	        if(que.size()<2 && que.peek()<K){
	            return -1;
	        }
	        
	        return answer;
	    }

}
