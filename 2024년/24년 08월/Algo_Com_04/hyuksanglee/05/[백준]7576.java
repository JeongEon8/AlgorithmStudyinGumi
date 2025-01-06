package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Beakjoon7576 {

	static Queue<int[]> que = new ArrayDeque<>();
	static int[][] arr;
	static int[] place;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int M,N;
	static int result = 0;

	public static void bfs() {
		while (!que.isEmpty()) {
			int[] q = que.poll();
			int x = q[0];
			int y = q[1];
			int b = q[2];
			
			for(int i = 0; i<4; i++) {
				
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || nx>=M || ny <0|| ny >= N) {
					continue;
				}
				if(arr[ny][nx] ==0) {
					arr[ny][nx] = b+1;
					place = new int[3];
					place[0]=nx;
					place[1]=ny;
					place[2]= b+1;
					que.offer(place);
				}
				
			}
			
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] input = in.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);

		

		arr = new int[N][M];
		for (int n = 0; n < N; n++) {
			input = in.readLine().split(" ");
			for (int m = 0; m < M; m++) {
				arr[n][m] = Integer.parseInt(input[m]);

				if (Integer.parseInt(input[m]) == 1) {
					place = new int[3];
					place[0] = m;
					place[1] = n;
					place[2] = 1;
					que.offer(place);
				}

			}
		}

		bfs();
		
		int check = 0;
		int result = 0;
		
		for (int n = 0; n < N; n++) {
			
			for (int m = 0; m < M; m++) {
				if(arr[n][m] ==0) {
					check=1;
					result =0;
					break;
				}
				if(result< arr[n][m]) {
					result = arr[n][m];
				}
				

			}
			if(check ==1) {
				break;
			}
		}
		
		
		System.out.print(result-1);

	}

}
