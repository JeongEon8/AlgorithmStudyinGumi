package bfs;

import java.io.*;
import java.util.*;

public class Baekjoon7569 {

	static class Point {
        int h, m, n, t;
        Point(int h, int m, int n, int t) {
            this.h = h;
            this.m = m;
            this.n = n;
            this.t = t;
        }
    }
	
	public static void main(String[] args)throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int H = Integer.parseInt(input[2]);
		
		int[][][] map = new int[H][M][N];
		int total = N*M*H;
		int type = 1;
		
		int[] dn = {0, 0, 0, 0, 1, -1};
		int[] dm = {0, 0, 1, -1, 0, 0};
		int[] dh = {1, -1, 0, 0, 0, 0};
		
		Queue<Point> que = new ArrayDeque<Point>();
		for(int h =0 ; h<H; h++) {
			for(int m = 0; m<M; m++) {
				input = in.readLine().split(" ");
				for(int n = 0; n<N; n++) {
					int num = Integer.parseInt(input[n]);
					map[h][m][n] = num;
					if(num == -1) {
						total--;
					}
					if(num == 1) {
						Point p = new Point(h, m, n,1);
						que.add(p);
						total--;
					}
				}
			}
		}
		
	  
	   
	   while(!que.isEmpty()) {
		   Point po = que.poll();
		   for(int d = 0; d<6; d++) {
			   int cn = po.n + dn[d];
			   int cm = po.m + dm[d];
			   int ch = po.h + dh[d];
			   
			   if(cn <0 || cm<0 || ch <0 || cn>=N || cm >= M || ch >=H) {
				   continue;
			   }
			   if(map[ch][cm][cn] == 0) {
				   total--;
				   map[ch][cm][cn] = po.t+1;
				   if(type < po.t+1) {
					   type = po.t+1;
				   }
				   Point ppo = new Point(ch, cm, cn, po.t+1);
				   que.add(ppo);
			   }
		   }
		   
	   }
		
		
		if(total <=0) {
			System.out.println(type-1);
		}else {
			System.out.println(-1);
		}
		
		
		
		
		
		
	}

}
