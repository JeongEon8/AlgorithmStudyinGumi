package 고득점Kit;

import java.util.Arrays;

public class Programmers_입국심사 {

	public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        int len = times.length;
        long end = Long.MAX_VALUE;
        long start =1;
        while(start<=end){
            long mid = end/2 + start/2;
            long count = 0;
            
           for (int t : times) {
                count += mid / t;
                if (count >= n) break; 
            }
            if(count>=n){
                answer=mid;
                end = mid-1;
                
            }else {
                start = mid+1;
            }
        }
        
        return answer;
    }

}
