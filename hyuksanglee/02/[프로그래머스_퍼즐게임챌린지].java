package programmers;

import java.util.*;

public class Programmers_퍼즐게임챌린지 {

	static class Info implements Comparable<Info> {
        int lev;
        int time;
        
        
        Info(int lev, int time){
            this.lev = lev;
            this.time = time;
        }
        
        @Override
		public int compareTo(Info o) {
			
			return o.lev - this.lev;
		}
        
        
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        long total = 0;
        int maxLev = 0;
        int n = diffs.length;
        
        Info[] infos = new Info[diffs.length];
        
        
        for(int i = 0; i< times.length; i++){
            total += times[i];
        }
        
        
        for(int i = 0; i<diffs.length; i++){
            if(maxLev < diffs[i]){
                maxLev = diffs[i];
            }
        }
        
        for(int i = 0; i<diffs.length; i++){
            if(i == 0){
                Info info = new Info(diffs[i],times[i]);
                infos[i] = info;
            }else{
                Info info = new Info(diffs[i],times[i]+times[i-1]);
                infos[i] = info;
            }   
        }
        Arrays.sort(infos);
        
       
        int left =1;
        int right = maxLev;
        
        while(left<=right){
            long total2 = total;
            int mid = (left+right) /2;
             for(int i =0; i< infos.length; i++){
                if(infos[i].lev <= mid){
                    break;
                }
               total2 += (infos[i].time*(infos[i].lev-mid));
            }
             if (total2 <= limit) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
        }
        
        
        
        
        
        
        return answer;
    }

}
