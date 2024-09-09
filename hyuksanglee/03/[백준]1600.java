package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Beakjoon1600 {

	static int W, H, K;
	
	static int[][] map;
	
	// 방문 처리
	static boolean[][][] isSelected;
	
	// 일반 움직임
	static int[] dwM = { 1, 0, -1, 0 };
	static int[] dhM = { 0, -1, 0, 1 };

	// 말의 움직임
	static int[] dwH = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[] dhH = { -1, -2, -2, -1, 1, 2, 2, 1 };

	// 원숭이의 정보
	public static class Monkey {
		int k; // 말의 움직임 가능 횟수
		int w; // 가로 위치
		int h; // 세로 위치
		int count; // 지금까지 움직인 횟수

	}

	public static int bfs() {
		Monkey monkey = new Monkey();
		monkey.k =K;
		monkey.w = 0;
		monkey.h = 0;
		monkey.count =0;
		
		Queue<Monkey> que = new ArrayDeque<>();
		que.offer(monkey);
		int result =-1;
		
		while(!que.isEmpty()) {
			monkey = que.poll();
			int k = monkey.k;
			int w = monkey.w;
			int h = monkey.h;
			int count =monkey.count;
			
			if(w==W-1 && h ==H-1) {
				result=count;
				break;
			}

			
			if(k>0) { // 말의 능력 있을때
				for(int d = 0; d<8; d++) {
					int nw = w + dwH[d];
					int nh = h + dhH[d];
					if(nw < 0 || nh < 0 || nw>=W || nh>=H) { // 맵 밖으로 벗어 날때
						continue;
					}
					if(map[nh][nw] ==0) {
						if(isSelected[nh][nw][k-1]==false) {
							isSelected[nh][nw][k-1]=true;
							monkey = new Monkey();
							monkey.k =k-1;
							monkey.w = nw;
							monkey.h = nh;
							monkey.count =count+1;
							que.add(monkey);
						
						
					}
					
				}
			}
			}
			for(int d =0; d<4; d++) {
				int nw = w + dwM[d];
				int nh = h + dhM[d];
				if(nw < 0 || nh < 0 || nw>=W || nh>=H) { // 맵 밖으로 벗어 날때
					continue;
				}
				if(map[nh][nw] ==0) {
					if(isSelected[nh][nw][k]==false) {
						isSelected[nh][nw][k]=true;
						monkey = new Monkey();
						monkey.k =k;
						monkey.w = nw;
						monkey.h = nh;
						monkey.count =count+1;
						que.add(monkey);
						
					}
					
				}
				
			}
			
		
		}
		return result;
			
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(in.readLine());
		String[] input = in.readLine().split(" ");

		// 가로 세로 길이
		W = Integer.parseInt(input[0]);
		H = Integer.parseInt(input[1]);
		map = new int[H][W];
		isSelected = new boolean[H][W][K+1];

		for (int h = 0; h < H; h++) {
			input = in.readLine().split(" ");
			for (int w = 0; w < W; w++) {
				map[h][w] = Integer.parseInt(input[w]);
			}

		}
		
		int result = bfs();
		
		System.out.println(result);

	}

}