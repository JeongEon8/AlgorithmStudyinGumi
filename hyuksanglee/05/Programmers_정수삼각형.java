package 고득점Kit;

public class Programmers_정수삼각형 {

	static int[][] arr;
    static int answer = 0;
    static int[][] dp;
    
    public int solution(int[][] triangle) {
        answer = 0;
        int len = triangle.length;
        arr = new int[len][len];
        dp = new int[len][len];
        for(int i = 0; i<len; i++){
            for(int j = 0; j<=i; j++){
                arr[i][j] = triangle[i][j];
            }
        }
        
        dp[0][0] = arr[0][0];
        for(int depth =1 ; depth<len; depth++){
            for(int i =0; i <= depth; i++){
                int max = 0;
                
                if(i==0){
                    max = dp[depth-1][i];
                }else if(i == depth){
                    max = dp[depth-1][i-1]; 
                }else{
                   max = Math.max(dp[depth - 1][i], dp[depth - 1][i - 1]);
                }
                dp[depth][i]= max + arr[depth][i];
                if(answer<dp[depth][i]){
                    answer=dp[depth][i];
                }
            }
        }
            
        return answer;
    }

}
