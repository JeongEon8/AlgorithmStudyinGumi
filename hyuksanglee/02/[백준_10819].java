package 그래프;

import java.io.*;

public class Baekjoon10819 {
	
	static int N;
	static int[] arr;
	static boolean[] check;
	static int max =0;

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		
		String[] input = in.readLine().split(" ");
		arr = new int[N];
		check = new boolean[N];
		
		for(int n = 0; n < N; n++) {
			
			arr[n] = Integer.parseInt(input[n]);
		}
		
		for(int n = 0; n < N; n++) {
			check[n] = true;
			dfs(arr[n], 0, 1);
			check[n] =false;
		}
		
		System.out.println(max);
		

	}
	
	static void dfs(int num, int total, int count) {
		
		if(count ==N) {
			if(max < total) {
				max = total;
			}
			return;
		}
		
		for(int n = 0; n < N; n++) {
			
			if(!check[n]) {
				int sum = total+ Math.abs(num-arr[n]);
				check[n]= true;
				dfs(arr[n], sum, count +1);
				check[n] = false;
			}
		}
		
	}

}
