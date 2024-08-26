package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beakjoon10026 {

	static boolean[][] isSelected;
	static String[][] arr;
	static int N;

	static int[] dj = { 1, 0, -1, 0 };
	static int[] di = { 0, 1, 0, -1 };

	public static void dfs(int i, int j) {
		for(int d = 0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(ni<0 || ni >=N || nj <0 || nj>=N ) {
				continue;
			}
			
			if(arr[ni][nj].equals(arr[i][j]) && isSelected[ni][nj] == false) {
				isSelected[ni][nj] = true;
				
				dfs(ni,nj);
				if(arr[ni][nj].equals("G")) {
					arr[ni][nj]="R";
				}
			}
			
		}
	}
	
	

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		arr = new String[N][N];
		isSelected = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			arr[i] = in.readLine().split("");

		}

		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (isSelected[i][j] == false) {
					isSelected[i][j] = true;
					
					result++;
					dfs(i, j);
					if(arr[i][j].equals("G")) {
						arr[i][j]="R";
					}
				}
			}
		}
		
		int result2 = 0;
		isSelected = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (isSelected[i][j] == false) {
					isSelected[i][j] = true;
					
					result2++;
					dfs(i, j);
				}
			}
		}
		
		
		System.out.print(result+ " " + result2);

	}

}
