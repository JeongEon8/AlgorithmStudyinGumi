package 이분탐색;

import java.io.*;
import java.util.*;

public class Baekjoon2473 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		long[] arr = new long [N];
		String[] input = in.readLine().split(" ");
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(arr);
		
		long[] result = new long[3];
		long max = Long.MAX_VALUE;
		
		for(int i = 0; i<N; i++) {
			int j = i+1;
			int k = N-1;
			while(j<k) {
				if(max>  Math.abs(arr[i]+arr[j]+arr[k])) {
					max = Math.abs(arr[i]+arr[j]+arr[k]);
					result[0] = arr[i];
					result[1] = arr[j];
					result[2] = arr[k];
					if(max ==0) {
						for(int z =0; z<3; z++) {
							System.out.print(result[z]);
							System.out.print(" ");
						}
						return;
						
					}
				}
				if(arr[i]+arr[j]+arr[k]>0) {
					k--;
				}else if(arr[i]+arr[j]+arr[k]<0) {
					j++;
				}
			}
		}
		
		for(int i =0; i<3; i++) {
			System.out.print(result[i]);
			System.out.print(" ");
		}
	}

}
