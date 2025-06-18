package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Baekjoon2636 {
	
	static class Place{
		int we;
		int he;
		
		public Place(int he, int we) {
			this.we = we;
			this.he = he;
		}
	}
	
	static int[] dw = {1,0,-1,0};
	static int[] dh = {0,1,0,-1};
	static int total1;

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 가로, 세로 입력 받
		String[] input = in.readLine().split(" ");
		int height = Integer.parseInt(input[0]);
		int weight = Integer.parseInt(input[1]);
		int [][] map = new int [height][weight];
		
		// 방문 여부를 파악하려
		int [][] isVisited = new int [height][weight];
		
		for(int h = 0; h<height; h++) {
			// 한줄씩 입력 받기
			input = in.readLine().split(" ");
			for(int w = 0 ; w < weight; w++) {
				// map배열에 하나씩 담기
				map[h][w]=Integer.parseInt(input[w]);
			}
			
		}
		boolean check = true;
		int count = 1;
		
		while(check) {
			Queue<Place> que = new ArrayDeque();
			Place data = new Place(0,0);
			que.add(data);
			isVisited[0][0] = count;
			int total = 0;
			
			while(!que.isEmpty()) {
				Place newData = que.poll();
				
				for(int d = 0; d<4; d++) {
					int h = newData.he + dh[d];
					int w = newData.we + dw[d];
					if(h<0 || w<0 || h>=height || w>=weight) {
						continue;
					}
					if(isVisited[h][w] == count) {
						continue;
					}
					
					isVisited[h][w] = count;
					if(map[h][w]==0) {
						
						Place inputData = new Place(h,w);
						que.add(inputData);
					}
					if(map[h][w]==1) {
						total++;
					}
					map[h][w]=0;
					
					
				}
				
			}
			if(total ==0) {
				check=false;
			}else {
				total1=total;
			}
			
			count++;
//			System.out.println(total);
			for(int i = 0; i<map.length; i++) {
				for(int j = 0; j<map[0].length; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			
			System.out.println();
			System.out.println(total);
				
		}
		
		System.out.println(count-1);
		System.out.println(total1);
		

	}

}
