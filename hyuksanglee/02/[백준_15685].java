package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon15685 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		boolean[][] map = new boolean[101][101];
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		
		for(int n = 0; n<N; n++) {
			String[] input = in.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			int d = Integer.parseInt(input[2]);
			int g = Integer.parseInt(input[3]);
			
			map[y][x]= true;
			
			
			List<Integer>arr = new ArrayList();
			x += dx[d];
			y += dy[d];
			map[y][x] = true;
			arr.add(d);
			
			while(g-->0) {
				
				for(int i = arr.size()-1 ; i>=0; i--) {
					int dn = arr.get(i);
					dn++;
					if(dn>3) {
						dn=0;
					}
					x += dx[dn];
					y += dy[dn];
					map[y][x]= true;
					arr.add(dn);
				}
				
				
				
			}
			
			
		}
		int count =0;
		for(int i =0; i<100; i++) {
			for(int j = 0; j<100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1] ) {
					count++;
				}
			}
		}
		
		System.out.println(count);
		
	}
	

}
