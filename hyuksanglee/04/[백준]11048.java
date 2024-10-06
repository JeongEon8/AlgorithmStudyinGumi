package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon1048 {
	public static int N, M;
	public static int[][] map;
	public static int[][] dp;

	public static int[] di = { 1, 0, 1 };
	public static int[] dj = { 0, 1, 1 };

	

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] input = in.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		map = new int[N][M];
		dp = new int[N][M];
		

		for (int n = 0; n < N; n++) {
			input = in.readLine().split(" ");
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(input[m]);
			}
		}
		
		dp[0][0]= map[0][0];
		for(int n =0; n<N; n++) {
			for(int m=0; m<M; m++) {
				for(int d =0; d<3; d++) {
					int ni = n+di[d];
					int nj = m+dj[d];
					if(ni<0 || nj<0||ni>=N || nj>=M) {
						continue;
					}
					
					if(dp[ni][nj] < dp[n][m] + map[ni][nj]) {
						dp[ni][nj]=dp[n][m] + map[ni][nj];
					}
				}
			}
		}
		System.out.println(dp[N-1][M-1]);

	}

}
