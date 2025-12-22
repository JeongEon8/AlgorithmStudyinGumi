package programmers;
import java.util.*;

public class Pragrammers_디펜스게임 {

	public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        int len = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int l = 0; l<len; l++){
            answer++;
            int e = enemy[l];
            n -= e;
            pq.add(e);
            if(n<0){
                while(n<0 && k>0){
                    int s = pq.poll();
                    n+=s;
                    k--;
                }
            }
            
            if(n<0 && k<=0){
                return answer-1;
            }
        }
        
        return answer;
    }
}
