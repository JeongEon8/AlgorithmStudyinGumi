package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon1922 {
	
	public static int N, M;
	
	public static int[][] arr;
	
	public static int[] cost;
	
	public static boolean [] isSelected;
	
	public static void dfs(int n, int count) {
		if(count>N) {
			return;
		}
		
		int index =0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<N; i++) {
			if(!isSelected[i]) {
				
				if(arr[n][i]<cost[i] && arr[n][i]!=0) {
					cost[i]=arr[n][i];
				}
				if(min>cost[i]) {
					min = cost[i];
					index = i;
				}
				
			}
		}
		
		isSelected[index] =true; 
		dfs(index,count+1);
	}

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		cost = new int[N];
		isSelected = new boolean[N];
		
		for(int n = 0; n<N; n++) {
			cost[n] = Integer.MAX_VALUE;
		}
		
		
		for(int m = 0; m<M; m++) {
			String[] input = in.readLine().split(" ");
			int a = Integer.parseInt(input[0])-1;
			int b = Integer.parseInt(input[1])-1;
			int c = Integer.parseInt(input[2]);
			
			arr[a][b] = c;
			arr[b][a] = c;
			
		}
		cost[0] =0;
		isSelected[0] = true;
		dfs(0,1);
		int result = 0;
		for(int n : cost) {
			result += n;
		}
		
		System.out.println(result);
		
		
		
		

	}

}
