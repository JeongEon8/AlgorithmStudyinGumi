package beakjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1261 {
	
	static int N,M;
	static int[][] arr, count;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] isVisited;
	
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		N = Integer.parseInt(input[1]);
		M = Integer.parseInt(input[0]);
		
		arr = new int[N][M];
		isVisited = new boolean[N][M];
		count = new int[N][M];

		for(int n = 0 ; n<N; n++) {
			input= in.readLine().split("");
			for(int m = 0; m< M; m++) {
				arr[n][m]= Integer.parseInt(input[m]);
				count[n][m] = Integer.MAX_VALUE;
			}
		}
		
		bfs();
		System.out.print(count[N-1][M-1]);
	}
	
	static class Info{
		int x;
		int y;
		int br;
		Info(int x, int y, int br){
			this.x = x; 
			this.y = y;
			this.br = br;
		}
	}
	
	static void bfs() {
		Deque<Info>que = new ArrayDeque<Info>();
		Info info = new Info(0,0,0);
		isVisited[0][0] = true;
		que.add(info);
		
		while(!que.isEmpty()) {
			Info data = que.poll();
			for(int d = 0; d<4; d++) {
				int nx = data.x+dx[d];
				int ny = data.y+dy[d];
				if(nx<0 || nx>=M || ny<0 || ny>=N) {
					continue;
				}
				if(count[ny][nx]>data.br+arr[ny][nx]) {
					
					int newBr = data.br;
					if(arr[ny][nx]==1) {
						newBr+=1;
						count[ny][nx]=data.br+1;
						Info newData = new Info(nx,ny,newBr);
						que.addLast(newData);
					}else {
						count[ny][nx]=data.br;
						Info newData = new Info(nx,ny,newBr);
						que.addFirst(newData);
					}

				}
			}
		}
	}

}
