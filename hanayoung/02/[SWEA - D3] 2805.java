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

            int[][] maps = new int[N][N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                String str = st.nextToken();
                for(int j = 0; j < N; j++) {
                    maps[i][j] = str.charAt(j) - '0';
                }
            }

            int profit = 0;
            for(int j = 0; j < N; j++) {
                profit += maps[N/2][j];
            }

            for(int i = 0; i < N/2; i++) {
                // N/2를 기점으로 +-1 .. N/2까지
                profit += maps[i][N/2];
                profit += maps[N-1-i][N/2];
                for(int j = 1; j <= i; j++) {
                    profit += maps[i][N/2-j];
                    profit += maps[i][N/2+j];
                    profit += maps[N-1-i][N/2-j];
                    profit += maps[N-1-i][N/2+j];
                }
            }

            System.out.println("#"+test_case+" "+profit);
		}
	}
}
