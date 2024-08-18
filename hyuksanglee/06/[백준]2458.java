package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Beakjoon2458 {
	static Set<Integer> set;
	static int N, M;
	static boolean[][] arr;
	

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] input = in.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		
		arr = new boolean[N+1][N+1];
		int[] relation = new int[N+1];

		for (int m = 0; m < M; m++) {
			input = in.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			arr[a][b] =true;
			
		}
		
		for(int k =1; k<=N; k++) {
			for(int i =1; i<=N; i++) {
				for(int j =1; j<= N; j++) {
					if(arr[i][k] && arr[k][j]) {
						arr[i][j] = true;
					}
				}
			}
		}
		
		for(int i =0; i<=N; i++) {
			for(int j =0; j<=N; j++){
				if(arr[i][j]) {
					relation[i] +=1;
					relation[j] +=1;
				}
			}
		}
		
		
		
		int count = 0;
		for(int i = 1; i<=N; i++) {
			if(relation[i]==N-1) {
				count++;
			}
		}
		System.out.println(count);
	}
}
