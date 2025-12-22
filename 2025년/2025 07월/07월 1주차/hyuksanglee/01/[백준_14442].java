package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Baekjoon14442 {

	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map;
	static boolean[][][] isVisited;
	static int N;
	static int M;
	static int K;
	static Queue<Info> que ;
	
	static int result;
	
	static class Info{
		int x;
		int y;
		int skill;
		int count;
		Info(int x, int y, int skill, int count) {
			this.x = x;
			this.y =y;
			this.skill = skill;
			this.count = count;
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		
		map = new int[N][M];
		isVisited = new boolean[N][M][K+1];
		
		que = new ArrayDeque<>();
		
		// 맵 정보 넣기 
		for( int n = 0; n<N; n++) {
			input = in.readLine().split("");
			for(int m = 0; m<M; m++) {
				map[n][m] = Integer.parseInt(input[m]);
			}
		}
		result = -1;
		bfs();
		
		System.out.println(result);
		
	}
	
	
	
	static void bfs() {
		que.add(new Info(0, 0, K,1));
		while(!que.isEmpty()) {
			Info newInfo = que.poll();
			int x = newInfo.x;
			int y = newInfo.y;
			int skill = newInfo.skill;
			if(x==M-1 && y== N-1) {
				result = newInfo.count;
				return;
			}
			for(int d =0; d<4; d++) {
				int newX = x+dx[d];
				int newY = y+dy[d];
				
				if(newY <0 || newX <0 || newY>=N || newX>=M) {
					continue;
				}
				if(map[newY][newX]==0 && !isVisited[newY][newX][skill]) {
					isVisited[newY][newX][skill] = true;
					Info inputInfo = new Info(newX, newY, skill, newInfo.count+1);
					que.add(inputInfo);
				}else if(map[newY][newX]==1 && skill>0 && !isVisited[newY][newX][skill - 1]) {
					isVisited[newY][newX][skill-1] = true;
					Info inputInfo = new Info(newX, newY, skill-1, newInfo.count+1);
					que.add(inputInfo);
				}
			}
		}
	}

}
