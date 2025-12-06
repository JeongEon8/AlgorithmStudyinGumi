package 시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beakjoon18808 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int K = Integer.parseInt(input[2]);
		int[][] map = new int[N][M];	
		int result = N*M;
		
		for(int k = 0; k<K; k++) {
			input = in.readLine().split(" ");
			int R = Integer.parseInt(input[0]);
			int C = Integer.parseInt(input[1]);
			int[][] st = new int[R][C];
			
			for(int r = 0; r< R; r ++) {
				input = in.readLine().split(" ");
				for(int c = 0; c<C; c++) {
					st[r][c] = Integer.parseInt(input[c]);
				}
			}
			
			check1 :for(int i = 0; i<4; i++) {
				
				for(int n = 0; n<N; n++) {
					for(int m =0; m<M; m++) {
						
						boolean ch = true;
						check2 :for(int r=0; r<st.length; r++) {
							for(int c = 0; c<st[0].length; c++) {
								if(n+r >=N || m+c>=M) {
									ch = false;
									break check2;
								}
								if(st[r][c]==1 && map[n+r][m+c]==1) {
									ch = false;
									break check2;
								}
							}
						}
						if(ch) {
							for(int r=0; r<st.length; r++) {
								for(int c = 0; c<st[0].length; c++) {
									
									if(st[r][c] == 1) {
										map[n+r][m+c] =st[r][c];
										result -=1;
									}
									
									
								}
							}
							break check1;
						}
						
						
						
						
					}
				}
				
				st = rotate90(st);
				
			}
				
		}
		
		System.out.println(M*N-result);
		

	}
	
	 // 90도 시계방향 회전
    static int[][] rotate90(int[][] src) {
        int R = src.length;
        int C = src[0].length;
        int[][] rot = new int[C][R];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                rot[c][R - 1 - r] = src[r][c];
            }
        }
        return rot;
    }

}
