package beakjoon;

import java.io.*;
import java.util.Arrays;

public class Baekjoon2230 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		
		String[] input = in.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[] arr = new int[N];
		
		for(int n = 0; n<N; n++) {
			arr[n] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(arr);
		
		int index = 0;
		int result = Integer.MAX_VALUE;
		int type = 0;
		
		for(int n = 0; n<N; n++) {
			while(arr[index]-arr[n]<M) {
				index++;
				if(index>N-1) {
					type = 1;
					break;
				}
			}
			if(type==1) {
				break;
			}
			if(arr[index]-arr[n]<result) {
				result = arr[index]-arr[n];
			}
		}
		
		
		
		System.out.println(result);
		
	}

}
