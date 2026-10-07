class Solution {
    
    
    public long solution(int n) {
        int answer =0;
        long[] dp = new long[n+1];
        
        
        for(int i =1; i<= n; i++){
            if(i==1)dp[1] =1;
            else if(i ==2)dp[2] =2;
            else dp[i] = (dp[i-1]+dp[i-2])% 1234567;
        }
        return dp[n] ;
    }
    

}
