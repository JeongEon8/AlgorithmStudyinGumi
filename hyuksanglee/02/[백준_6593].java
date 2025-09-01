package beakjoon;

import java.io.*;
import java.util.*;

public class Baekjoon6593 {
	
	// 빌딩의 맵 정보 담는 배열
	static String [][][] building;
	// 방문처리 배열
	static boolean [][][] isCheck;
	// 출입구 정보 담는 배열
	static int[][] doorway;
	
	// 빌딩 층수, 행, 열 담는 변수
	static int L, R, C;
	
	// 주변 이동할 좌표
	static int[] dl = {1, -1, 0, 0, 0, 0}; 		// 층수
	static int[] dr = {0, 0, 1, -1, 0, 0};	// 행
	static int[] dc = {0, 0, 0, 0, 1, -1};	// 열

	public static void main(String[] args)throws Exception {
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			// 입력 값 받기
			String[] input = in.readLine().split(" ");
			
			// 빌딩의 층수
			L = Integer.parseInt(input[0]);
			
			// 빌딩의 행
			R = Integer.parseInt(input[1]);
			
			// 빌딩의 열
			C = Integer.parseInt(input[2]);
			
			// 테스트 케이스 종료
			if(L == 0 && R == 0 && C == 0) {
				break;
			}
			
			// 빌딩의 맵 정보 초기화
			building = new String [L][R][C];

			isCheck = new boolean[L][R][C];
			
			// 출입구 정보 초기화
			doorway = new int [2][3];
			
			// 빌딩의 층수만큼 반복
			for(int l =0; l<L; l++) {
				
				// 빌딩의 행만큼 반복
				for(int r =0; r<R; r++) {
					input = in.readLine().split(""); // l층의 r줄에 맵정보 받기
					for(int c = 0; c<C; c++) {
						building[l][r][c] = input[c];
						
						if(input[c].equals("S")) { // 입구 좌표 담기
							doorway[0][0] = l;
							doorway[0][1] = r;
							doorway[0][2] = c;
						}else if(input[c].equals("E")) { // 출구 좌표 담기
							doorway[1][0] = l;
							doorway[1][1] = r;
							doorway[1][2] = c;
						}
					}
				}
				input = in.readLine().split("");
			}
			
			int result = bfs();
			
			// 결과에 맞게 출력 변경
			if(result > 0) {
				System.out.println("Escaped in "+result+" minute(s).");
			}else {
				System.out.println("Trapped!");
			}
			
		}
	}
	
	// 현재 위치를 담는 클래스
	static class Info{
		int l;
		int r;
		int c;
		int count;
		Info(int l, int r, int c, int count){
			this.l = l;
			this.r = r;
			this.c = c;
			this.count = count;
		}
	}
	
	// bfs
	static int bfs() {
		
		// 큐 생
		Queue<Info> que = new ArrayDeque<Info>();
		// 시작점 넣기
		Info inputInfo = new Info(doorway[0][0],doorway[0][1],doorway[0][2],0);
		// 현재 위치 방문처리 하기
		isCheck[doorway[0][0]][doorway[0][1]][doorway[0][2]] = true;
		// 큐에 시작점 담기
		que.add(inputInfo);
		
		// 큐에 값이 비어있을때까지 반복
		while(!que.isEmpty()) {
			// 큐에서 현재 좌표 꺼내기
			Info infoC = que.poll();
			
			// 출구에 도착했을 때
			if(infoC.l == doorway[1][0] && infoC.r == doorway[1][1] && infoC.c == doorway[1][2]) {
				return infoC.count;
			}
			
			// 주변 탐색
			 
			for( int d =0; d<6; d++) { 	
				int nl = infoC.l + dl[d]; 	// 탐색하려는 층수
				// 상, 하, 좌, 우
				int nr = infoC.r + dr[d]; 	 
				int nc = infoC.c + dc[d];
				
				// 탐색하려는 좌표가 건물 밖에 나가면 건너뛰기
				if(nl <0 || nr <0 || nc < 0 || nl>=L || nc>= C || nr >= R) {
					continue;
				}
				if( isCheck[nl][nr][nc]== false && !building[nl][nr][nc].equals("#")) { // 한번도 방문하지 않았고 금이 가지 않은 곳
					Info newInfo = new Info(nl, nr, nc, infoC.count+1);
					que.add(newInfo);
					// 현재 위치 방문처리 하기
					isCheck[nl][nr][nc] = true;
				}
				
				
			}
		}
		
		return 0;
	}

}
