
import java.util.*;

class Solution {
    
    static int[][] cost;
    static int[][] hint;
    static int len,answer;

    public int solution(int[][] cost, int[][] hint) {
       answer = Integer.MAX_VALUE;

        this.cost = cost;
        this.hint = hint;
        len = cost.length;
        int[] count = new int[len+1];
        dfs(1,cost[0][0],count);
        for(int j = 1; j<hint[0].length; j++){
            count[hint[0][j]]++;    
        }
        dfs(1,cost[0][0]+ hint[0][0],count);
        return answer;
    }
    
    static void dfs(int step, int total, int[] count){
        if(step == len){
            answer = Math.min(answer, total);
            return;
        }
         int use = Math.min( count[step + 1], cost[step].length - 1 );
        
        int stageCost = cost[step][use];
        
        dfs(step+1, total+ stageCost, count);
        if (step < hint.length) {
            for(int j = 1; j<hint[step].length; j++){
                count[hint[step][j]]++;    
            }
        
            dfs( step + 1, total + stageCost + hint[step][0], count );

            for(int j = 1; j<hint[step].length; j++){
                count[hint[step][j]]--;    
            }
        }
        
        
    }
}
