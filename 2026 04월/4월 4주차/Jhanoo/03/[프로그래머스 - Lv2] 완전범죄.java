import java.util.*;

class Solution {
    
    static final int INF = 987654321;
    
    public int solution(int[][] info, int n, int m) {
        
        int[] dp = new int[m];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for (int[] cur : info) {
            int a = cur[0];
            int b = cur[1];
            
            int[] next = new int[m];
            Arrays.fill(next, INF);
            
            for (int j = 0; j < m; j++) {
                if (dp[j] == INF) continue;
                
                if (dp[j] + a < n) {
                    next[j] = Math.min(next[j], dp[j] + a);
                }
                
                if (j + b < m) {
                    next[j + b] = Math.min(next[j + b], dp[j]);
                }
            }
            
            dp = next;
        }
            
        int answer = INF;
        
        for (int value : dp) {
            answer = Math.min(answer, value);
        }
        
        return answer == INF ? -1 : answer;
    }
}