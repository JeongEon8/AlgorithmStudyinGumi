class Solution {
    public int solution(int n, int[] money) {
        int MOD = 1000000007;
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        
        for (int coin : money) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }
        
        return dp[n];
    }
}