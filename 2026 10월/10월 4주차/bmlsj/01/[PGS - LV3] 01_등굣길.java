class Solution {
    
    static int mod = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[n + 1][m + 1];
        
        boolean[][] isCheck = new boolean[n + 1][m + 1];
        for(int[] p: puddles) {
            int x = p[0];
            int y = p[1];
            
            isCheck[y][x] = true;
        }
        
        dp[1][1] = 1;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;
                if (isCheck[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }
                
                long fromTop = (i > 1) ? dp[i-1][j] : 0;
                long fromLeft = (j > 1) ? dp[i][j-1] : 0;
                
                dp[i][j] = (int) ((fromTop + fromLeft) % mod);
            }
        }
        
        return dp[n][m];
    }
}