import java.util.*;
class Solution {
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] win = new boolean[n+1][n+1];

        for(int[] result: results) {
            int winner = result[0];
            int loser = result[1];
            win[winner][loser] = true;
        }
        
        // a > b, b > c 이면, a > c
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if (win[i][k] && win[k][j]) {
                        win[i][j] = true;
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            
            for(int j = 1; j <= n; j++) {
                if (win[i][j] || win[j][i]) {
                    cnt++;
                }
            }
            
            if (cnt == n - 1) {
                answer++;
            }
        }
        
        
        return answer;
    }
}