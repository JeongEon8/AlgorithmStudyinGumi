package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon11066 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

       for(int t = 0; t<T; t++) {
            int K = Integer.parseInt(in.readLine());
            String[] input = in.readLine().split(" ");

            
            int[] sum = new int[K];
            int[][] dp = new int[K][K];

           
            sum[0] =  Integer.parseInt(input[0]);
            for (int i = 1; i < K; i++) {
                sum[i] = sum[i - 1] + Integer.parseInt(input[i]);
            }

            for (int len = 1; len < K; len++) {
                for (int i = 0; i < K - len; i++) {
                    int j = i + len ;
                    dp[i][j] = Integer.MAX_VALUE;

                    for (int k = i; k < j; k++) {
                    	int num = 0;
                    	if(i>0) {
                    		num = sum[i-1];
                    	}
                        int total = sum[j] - num;
                        if(dp[i][j] > dp[i][k] + dp[k + 1][j] + total) {
                        	dp[i][j] = dp[i][k] + dp[k + 1][j] + total;
                        }
                        
                    }
                }
            }

            System.out.println(dp[0][K - 1]);
        }
    }
}
