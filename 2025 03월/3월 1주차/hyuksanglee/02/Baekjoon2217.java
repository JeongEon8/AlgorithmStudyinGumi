package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2217 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		for(int n = 0; n<N; n++) {
			int num = Integer.parseInt(in.readLine());
			arr[n]=num;
		}
		
		Arrays.sort(arr);
		int max =0;
		for(int n = 0; n<N; n++) {
			
			arr[n]=arr[n]*(N-n);
			if(max<arr[n]) {
				max = arr[n];
			}
		}
		
		System.out.println(max);
		

	}

}
