package 그래프;

import java.io.*;
import java.util.Arrays;

public class Baekjoon15655 {

	static int N,M;
	static int[] arr;
	static boolean[] check;
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		input = in.readLine().split(" ");
		int l = input.length;
		
		arr = new int[l];
		check = new boolean[l];
		
		for(int i = 0 ; i<l ; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(arr);

		int[] result = new int[M];
		for(int i =0; i<N; i++) {
			check[i]= true;
			result[0] = arr[i];
			dfs(i+1, 1, result);
			check[i]=false;
		}
		
	}
	
	static void dfs(int i , int de, int[] result) {
		if(de>=M) {
			for(int n : result) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}
		
		for(int n = i; n<N; n++) {
			if(!check[n]) {
				check[n] = true;
				result[de] = arr[n];
				dfs(n+1, de+1, result);
				check[n] = false;
			}
		}
	}

}
