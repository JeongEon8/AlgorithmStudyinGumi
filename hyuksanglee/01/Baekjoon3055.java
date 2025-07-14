package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Baekjoon3055 {
	
	static int R;
	static int C;
	static char[][] map;
	static int[][] isCheck;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	static int time = 1;
	static boolean result = true;
	
	static class Info{
		int r;
		int c; 
		int t;
		Info(int r, int c, int t){
			this.r = r;
			this.c= c;
			this.t= t;
		}
	}

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader (new InputStreamReader( System.in));
		
		String[] input = in.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		map = new char[R][C];
		isCheck = new int[R][C];
		
		// 고슴도치 처음 위치
		int[] start = new int[2];
	
		for(int r = 0; r<R; r++) {
			input = in.readLine().split(" ");
			for(int c = 0; c<C; c++) {
				map[r][c]= input[0].charAt(c);
				if(input[0].charAt(c)=='S') {
					start[0]=r;
					start[1]=c;
				}
				if(input[0].charAt(c)=='*') {
					isCheck[r][c] = time;
				}
			}
		}
		
		dfs(start[0], start[1], 1);
		
		if(result) {
			System.out.println("KAKTUS");
		}
		
		
		

	}

	private static void dfs(int i, int j, int t) {
		Info info = new Info(i,j,t);
		Queue<Info> que = new ArrayDeque();
		
		que.add(info);
		
		while(!que.isEmpty()) {
			Info data = que.poll();
			int cr = data.r;
			int cc = data.c;
			int ct = data.t;
			
			if(ct >= time) {
				changeW(ct);
			}
			
			for(int d=0; d<4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				
				
				if(nr <0 || nc <0 || nr>=R || nc>=C) {
					continue;
				}
				
				if(map[nr][nc]=='D') {
					System.out.println(ct);
					result = false;
					return;
				}
				
				if(map[nr][nc] == '.' && isCheck[nr][nc]==0) {
					isCheck[nr][nc]=-1;
					Info newInfo = new Info(nr, nc, ct+1);
					que.add(newInfo);
				}
			}
			
			
		}
		
	}

	private static void changeW(int t) {
		for(int r = 0; r< R; r++) {
			for(int c = 0; c<C; c++) {
				if(isCheck[r][c] == t) {
					for(int d = 0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c + dc[d];
						if(nr<0 || nc <0 || nr>= R || nc >= C) {
							continue;
						}
						
						if(isCheck[nr][nc] <= 0 && map[nr][nc] == '.') {
							isCheck[nr][nc] = t+1;
							map[nr][nc] ='*';
						}
					}
				}
			}
		}
		time++;
		
	}

}
