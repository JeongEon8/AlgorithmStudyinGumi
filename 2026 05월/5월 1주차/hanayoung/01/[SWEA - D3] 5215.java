import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

		int T = Integer.parseInt(st.nextToken());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[][] eval = new int[N+1][2]; // [0]은 맛점수 [1]은 칼로리
            
            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(bf.readLine());
                eval[i][0] = Integer.parseInt(st.nextToken());
                eval[i][1] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N+1][L+1];

            for(int i = 1; i <= N; i++) {
                for(int j = 0; j <= L; j++) {
                    dp[i][j] = dp[i-1][j];
                    
                    if(j >= eval[i][1]) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - eval[i][1]] + eval[i][0]);
                }
            }

            System.out.println("#"+test_case+" "+dp[N][L]);
        }
	}
}
