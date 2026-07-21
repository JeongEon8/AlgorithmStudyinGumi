import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < enemy.length; i++){
            int currentEnemy = enemy[i];
            
            n -= currentEnemy;
            pq.add(currentEnemy);
            
            if(n < 0){
                if(k > 0){
                    k--;
                    n += pq.poll();
                }else{
                    return i;
                }
            }
        }
        
        return answer;
    }
}
