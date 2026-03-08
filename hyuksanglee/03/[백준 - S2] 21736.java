package 그래프;

import java.io.*;

public class Baekjoon21736 {
	
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,1,0,-1};
	static boolean[][] check;
	static int N,M,result;

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		
		result =0;
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		int Di =0;
		int Dj = 0;
		
		char[][] list = new char[N][M];
		check = new boolean[N][M];
		
		for(int n = 0; n<N; n++) {
			String st = in.readLine();
			for(int m = 0; m<M; m++) {
				char c = st.charAt(m);
				list[n][m] = c;
				
				if(c == 'I') {
					Di = n;
					Dj = m;
				}
			}
		}
		
		dfs(list, Di, Dj);
		if(result ==0) {
			System.out.println("TT");
		}else {
			System.out.println(result);
		}
		
		
	}
	
	static void dfs(char[][] list, int i, int j) {
		
		if(list[i][j]=='P') {
			result++;
		}
		
		for(int d = 0; d<4; d++) {
			int ci = i + di[d];
			int cj = j + dj[d];
			if(ci<0 || ci>=N || cj <0 || cj >=M) {
				continue;
			}
			
			if(!check[ci][cj] && list[ci][cj]!='X') {
				check[ci][cj] = true;
				
				dfs(list,ci,cj);
			}
		}
		return ;
	}

}
