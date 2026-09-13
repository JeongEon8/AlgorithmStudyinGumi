class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        int[] dp = new int[y+1];
        dp[x] = 1;
        for(int i = x; i<=y; i++){
            if(i>n&&dp[i-n]>0){
                dp[i] = dp[i-n]+1;
            }
            if(i%2==0&&dp[i/2]>0){
                dp[i] = dp[i]==0? dp[i/2]+1:Math.min(dp[i],dp[i/2]+1);
            }
            if(i%3==0&&dp[i/3]>0){
                dp[i] = dp[i]==0? dp[i/3]+1:Math.min(dp[i],dp[i/3]+1);
            }
        }
        if(dp[y]>0)answer= dp[y]-1;
        return answer;
    }
}