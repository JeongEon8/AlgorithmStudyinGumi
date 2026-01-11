package programmers;

import java.util.*;

public class Pragrammers_연속된_부분_수열의_합 {

	public static int[] main(String[] args,int[] sequence, int k) {
		 int len = sequence.length;
	        int size = Integer.MAX_VALUE;
	        int total = 0;
	        int a = 0;
	        int b = 0;
	    
	        Queue<Integer> que = new ArrayDeque<Integer>();
	        for(int l = len-1; l>=0; l--){
	            int n = sequence[l];
	            total+= n;
	            que.add(n);
	            while(total>k && !que.isEmpty()){
	                total -= que.poll();
	            }
	            if(total == k){
	                if(size >= que.size()){
	                  size = que.size();
	                    a = l;
	                    b = l+size-1;
	                }
	            }
	            
	        }
	        int[] answer = {a,b};
	        return answer;

	}

}
