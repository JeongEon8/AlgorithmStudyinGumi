package beakjoon;

import java.util.Scanner;
import java.util.*;

class Wormhole{
	int x;
	int y;
	Wormhole(){}
	
	Wormhole(int x, int y){
		this.x = x;
		this.y = y;
	}
}
class Solution
{
    static Wormhole[][] wormhole;
	static int[][]compare;
	static int[][]arr;
	static int N;
	
	static int[] dx = {1,0,-1,0}; // x 방향
	static int[] dy = {0,1,0,-1}; // y 방향
	
	public static void start(int x, int y) {
		int max = 0;
		for(int i=0; i<4; i++) {
			
			int result = move(x,y,i);
			if(max<result) {
				max = result;
			}
			
		}
		compare[y][x] =max;
	}
	
	
	// 블록 1일 때
	public static int block1(int type) {
		switch(type) {
		case 0:
			return 2;
		case 1:
			return 0;
		case 2:
			return 3;
		case 3:
			return 1;
		}
		
		return 0;
	}
	
	// 블록 2일 때
	public static int block2(int type) {
		switch(type) {
		case 0:
			return 2;
		case 1:
			return 3;
		case 2:
			return 1;
		case 3:
			return 0;
		}
		
		return 0;
	}
		
	// 블록 3일 때
	public static int block3(int type) {
		switch(type) {
		case 0:
			return 1;
		case 1:
			return 3;
		case 2:
			return 0;
		case 3:
			return 2;
		}
		
		return 0;
	}
	
	// 블록 4일 때
	public static int block4(int type) {
		switch(type) {
		case 0:
			return 3;
		case 1:
			return 2;
		case 2:
			return 0;
		case 3:
			return 1;
		}
		
		return 0;
	}
	
	// 블록 5일 때
	public static int block5(int type) {
		switch(type) {
		case 0:
			return 2;
		case 1:
			return 3;
		case 2:
			return 0;
		case 3:
			return 1;
		}
		
		return 0;
	}
	
	// 월홀일 
		public static Wormhole hole(int x, int y, int worm) {
			Wormhole h = new Wormhole();
			
			if(wormhole[0][worm].x == x & wormhole[0][worm].y == y) {
				h = wormhole[1][worm];
			}else {
				h = wormhole[0][worm];
			}
			
			return h;
		}
	
	
	
	
	public static int move(int x, int y, int type) {
		int nx = x;
		int ny = y;
		int count = 0;
		boolean out = true;
		boolean ch = false;
		Wormhole h = null;
		while(arr[ny][nx] != -1) {
			if(nx == x & ny == y & ch) {
				break;
			}
			ch = true;
			
			if(out) {
				nx += dx[type];
				ny += dy[type];
			}
			out = true;
			
			if( 0 <= nx & nx<N & 0 <= ny & ny <N) {
				switch(arr[ny][nx]) {
				case 1:
					type = block1(type);
					count ++;
					break;
				case 2:
					type = block2(type);
					count ++;
					break;
				case 3:
					type = block3(type);
					count ++;
					break;
				case 4:
					type = block4(type);
					count ++;
					break;
				case 5:
					type = block5(type);
					count ++;
					break;
				case 6:
					h = hole(nx,ny,6);
					nx = h.x;
					ny = h.y;
					break;
				case 7:
					h = hole(nx,ny,7);
					nx = h.x;
					ny = h.y;
					break;
				case 8:
					h = hole(nx,ny,8);
					nx = h.x;
					ny = h.y;
					break;
				case 9:
					h = hole(nx,ny,9);
					nx = h.x;
					ny = h.y;
					break;
				case 10:
					h = hole(nx,ny,10);
					nx = h.x;
					ny = h.y;
					break;
				}
			}else {
				type = (type+2)%4;
				nx += dx[type];
				ny += dy[type];
				count ++;
				out = false;
			}
			
		}
		return count;
		
	}
	public static void main(String args[]) 
	{
        Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
	        for (int test_case = 1; test_case <= T; test_case++) {
	        	int result = 0;
	          
	            N = sc.nextInt();
	            arr = new int[N][N]; // 입력받은 정수 담는 배열
	            compare = new int[N][N]; // 각 칸에 최댓값 담는 배열
	            
	            wormhole= new Wormhole[2][11]; // 웜홀 배
				
	            // 입력받은 숫자 배열에 담기
	            for(int n = 0; n < N; n++) {
	            	
	            	for(int i = 0; i<N; i++) {
	            		
	            		arr[n][i]=sc.nextInt();
	            		if(6<= arr[n][i] & arr[n][i]<=10) {
	            			if(wormhole[0][arr[n][i]] == null) {
	            				wormhole[0][arr[n][i]] = new Wormhole(i,n);
	            			}else {
	            				wormhole[1][arr[n][i]] = new Wormhole(i,n);
	            			}
	            		}
	            		
	            	}
	            	
	            }
	            
	           for(int y=0; y<N; y++) {
	        	   for (int x = 0; x<N; x++) {
	        		   if(arr[y][x]==0) {
	        			   start(x,y);
	        		   }
	        	   }
	           }
				
				
				
				for(int n = 0; n<N; n++) {
					for(int i = 0; i<N; i++) {
						if(result< compare[n][i]) {
							result = compare[n][i];
						}
					}
				}
				
				System.out.println("#"+test_case+" "+result);
				
				
	            
	        }
	}
}