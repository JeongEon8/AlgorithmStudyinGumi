package beakjoon;
import java.io.*;

public class Baekjoon14500 {
	
	static int[] dx = {0,1,2,3, 0,0,0,0, 0,1,0,1, 0,0,0,1, 0,1,2,0, 0,1,1,1, 0,1,2,2, 1,1,1,0, 0,0,1,2, 0,1,0,0, 0,1,2,2, 0,0,1,1, 0,1,1,2, 1,1,0,0, 0,1,1,2, 0,1,1,2, 1,1,0,1, 1,0,1,2, 0,0,1,0};
	static int[] dy = {0,0,0,0, 0,1,2,3, 0,0,1,1, 0,1,2,2, 0,0,0,1, 0,0,1,2, 1,1,1,0, 0,1,2,2, 0,1,1,1, 0,0,1,2, 0,0,0,1, 0,1,1,2, 1,1,0,0, 0,1,1,2, 0,0,1,1, 0,0,1,0, 0,1,1,2, 0,1,1,1, 0,1,1,2};

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[][] map = new int[N][M];
		int result =0;
		
		for(int n =0; n<N; n++) {
			input = in.readLine().split(" ");
			for(int m =0; m<M; m++) {
				map[n][m] = Integer.parseInt(input[m]);
			}
			
		}
		
		for(int n =0; n<N; n++) {
			for(int m =0; m<M; m++) {
				int d= -1;
				while(d<dx.length-1) {
					int sum =0;
					for(int i =0; i<4; i++) {
						d++;
						int x= m +dx[d];
						int y = n+dy[d];
						if(x<0 || y<0 || x>=M || y>=N) {
							continue;
						}
						sum += map[y][x];
						if(result < sum) {
							result =sum;
						}
					}
				}
				
			}
			
		}
		
		System.out.println(result);
		
		

	}

}
