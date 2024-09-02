package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Beakjoon2589 {
	
	static int[][] map;
	static int[][] isSelect;
	static int max;
	
	static int R, C;
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Place{
		int x;
		int y;
		public Place(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	public static void dfs(int x, int y) {
		
		Queue<Place> que = new ArrayDeque<>();	// 좌표를 받는 큐
		isSelect = new int [R][C];	// 방문 여부 배열 초기화	
		que.offer(new Place(x,y)); // 큐에 좌표 담기
		isSelect[y][x]=1; // 처음 들어왔을때 방문 체크
		
		while(!que.isEmpty()) {
			Place p = que.poll();
			
			int nx = p.x;
			int ny = p.y;
			
			// 상,하,좌,우 방향으로 육지체크
			for(int i = 0; i<4; i++) {
				int cx = nx + dx[i];
				int cy = ny + dy[i];
				
				if(cx < 0 || cx >= C || cy < 0 || cy >=R) {	// 지도 밖으로 나갔을때 예외처리
					continue;
				}
				
				if(map[cy][cx] ==0 && isSelect[cy][cx] == 0) { // 해당 지역이 육지이면서 방문을 안했을때
					que.offer(new Place(cx,cy));	// 큐에 좌표 넣기
					isSelect[cy][cx] = isSelect[ny][nx]+1; // 이동할곳 방문 체크( 전 판에 있던 시간 +1)
					
				}
				
			}
			
			
		}
		
		// 방문 여부에 최대시간 찾기
		for(int i =0;i < R; i++) {
			for(int j = 0; j<C; j++) {
				if(max<isSelect[i][j]) {
					max = isSelect[i][j];
				}
			}
		}
		
		
		
		
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");	// 지도의 세로와 가로 받기
		R = Integer.parseInt(input[0]);	// R : 세로
		C = Integer.parseInt(input[1]);	// C : 가로
		
		map = new int[R][C]; // 지도 초기화
		
		for(int r = 0; r < R; r++) {
			input = in.readLine().split("");
			for(int c = 0; c < C; c++) {
				if(input[c].equals("W")) {
					map[r][c] =1;	// 나중에 계산하기 편하게 정수로 수정
				}
			}
		}
		
		
		max = 0;	// 최댓값 초기화
		
		// 육지를 찾아서 dfs로 탐색한다.
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c]==0) {
					dfs(c,r);
				}
			}
		}
		
		
		System.out.println(max-1); // 출발 지역은 0이므로 -1해준다.
		
		
		
	}

}
