package programmers;

import java.util.*;

public class Programmers_서버증설횟수 {

	public int solution(int[] players, int m, int k) {
        int answer = 0;
        int len = players.length;
        
        for(int i = 0; i<len; i++){
            players[i] /=m;
        }
        
        Queue<Integer> que = new ArrayDeque<Integer>();
        
        for(int i = 0 ; i<len; i++){
            
            if(que.size()>0){
                while(!que.isEmpty() && que.peek()<=i){
                    que.poll();
                }
            }
            
            if(players[i]>que.size()){
                int need = players[i] - que.size();
                for(int j = 0; j<need; j++){
                   answer++;
                    que.add(i+k); 
                }
                
            }
            
        }
        return answer;
    }

}
