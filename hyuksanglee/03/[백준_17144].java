package beakjoon;


import java.io.*;
public class Baekjoon17144 {
	
	static int[][] map;
	static int R;
	static int C;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] input = in.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		int T = Integer.parseInt(input[2]);
		
		map = new int[R][C];
		int[] ar = new int[2];
		int[] ac = new int[2];
		boolean check = true;
		
		for(int r = 0; r<R; r++) {
			input = in.readLine().split(" ");
			for(int c = 0; c<C; c++) {
				map[r][c] = Integer.parseInt(input[c]);
				if(map[r][c] == -1) {
					if(check) {
						ar[0] = r;
						ac[0] = c;
						check = false;
					}else {
						ar[1] = r;
						ac[1] = c;
					}
				}
			}
		}
		
		
		for(int t = 0; t<T; t++) {
			dust();
			air( ar, ac);
		}
		
		int count =0;
		for(int r = 0; r<R; r++) {
			for(int c = 0; c<C; c++) {
				if(map[r][c] >0) {
					count += map[r][c];
				}
			}
			
		}
		
		System.out.println(count);
		
	}
	
	static void dust() {
		int[][] temporary = new int[R][C];
		for(int r =0 ; r< R; r++) {
			for(int c = 0; c< C; c++) {
				if(map[r][c] >1 ) {
					int divide = map[r][c]/5;
					for(int d = 0; d<4; d++) {
						int nr = r+ dr[d];
						int nc = c + dc[d];
						if(nr<0 || nc<0 || nr>=R || nc>= C || map[nr][nc] ==-1) {
							continue;
						}
						temporary[nr][nc] += divide;
						map[r][c] -= divide;
					}
				}
			}
		}
		
		for(int r =0 ; r< R; r++) {
			for(int c = 0; c< C; c++) {
				map[r][c] += temporary[r][c];
			}
		}
		
	}
	
	static void air(int[] r, int[] c) {
	    // 위쪽(반시계)
	    int top = r[0];
	    for (int i = top - 1; i > 0; i--) map[i][0] = map[i - 1][0];
	    for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i + 1];
	    for (int i = 0; i < top; i++) map[i][C - 1] = map[i + 1][C - 1];
	    for (int i = C - 1; i > 1; i--) map[top][i] = map[top][i - 1];
	    map[top][1] = 0;

	    // 아래쪽(시계)
	    int bottom = r[1];
	    for (int i = bottom + 1; i < R - 1; i++) map[i][0] = map[i + 1][0];
	    for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1];
	    for (int i = R - 1; i > bottom; i--) map[i][C - 1] = map[i - 1][C - 1];
	    for (int i = C - 1; i > 1; i--) map[bottom][i] = map[bottom][i - 1];
	    map[bottom][1] = 0;
	}


}
