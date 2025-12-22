package bfs;

import java.io.*;
import java.util.*;

public class Beakjoon1926 {
	
	static class Info{
		int i;
		int j;
		Info(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
	static int[] di = {1, 0, -1, 0};
	static int[] dj = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[][] map = new int[n][m];
		boolean[][] check = new boolean[n][m];
		
		for(int i = 0; i<n; i++) {
			input = in.readLine().split(" ");
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		Queue<Info> que = new ArrayDeque<Info>();
		int count = 0;
		int max =0;
		
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] ==1 && !check[i][j]) {
					count++;
					Info info = new Info(i,j);
					check[i][j] = true;
					que.add(info);
					int total = 1;
					while(!que.isEmpty()) {
						Info newInfo = que.poll();
						int ni = newInfo.i;
						int nj = newInfo.j;
						for(int d = 0; d<4; d++) {
							int ci = ni+ di[d];
							int cj = nj + dj[d];
							if(ci<0 || ci>=n || cj<0 || cj>=m) {
								continue;
							}
							
							if(map[ci][cj]==1 && !check[ci][cj]) {
								check[ci][cj] = true;
								total++;
								info = new Info(ci,cj);
								que.add(info);
							}
							
						}
					}
					if(max < total) {
						max = total;
					}
				}
			}
		}
		
		System.out.println(count);
		System.out.println(max);
		

	}

}
