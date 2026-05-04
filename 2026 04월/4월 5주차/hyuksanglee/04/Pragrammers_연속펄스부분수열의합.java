package programmers;

public class Pragrammers_연속펄스부분수열의합 {

    public long solution(int[] sequence) {
        
        int len = sequence.length;
        long[][] dp = new long[len][2];
        dp[0][0]=sequence[0]*(-1);
        dp[0][1]=sequence[0];
        long answer =  Math.max( dp[0][0], dp[0][1]);
        for(int i = 1; i< len; i++){
            dp[i][i%2] = sequence[i]*(-1);
            dp[i][(i+1)%2] = sequence[i];
            if(dp[i][0]+dp[i-1][0] > dp[i][0]){
                dp[i][0] = dp[i][0]+dp[i-1][0];
                if(answer< dp[i][0]){
                   answer = dp[i][0];
                }
            }
            if(dp[i][1]+dp[i-1][1] > dp[i][1]){
                dp[i][1] = dp[i][1]+dp[i-1][1];
                if(answer< dp[i][1]){
                   answer = dp[i][1];
                }
            }
        }
        
        return answer;
    }

}
