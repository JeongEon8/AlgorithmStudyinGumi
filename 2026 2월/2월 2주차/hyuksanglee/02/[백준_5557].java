package dp;

import java.io.*;

public class Baekjoon5557 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		long[][] arr = new long[N][21];
		
		String[] input = in.readLine().split(" ");
		for(int n = 0; n < N-1; n++) {
			int num = Integer.parseInt(input[n]);
			if(n==0) {
				arr[n+1][num] =1;
			}else {
				for(int i = 0; i<21; i++) {
					long nu = arr[n][i];
					if(nu >= 1) {
						int total = i + num;
						if(total <=20) {
							arr[n+1][total] += arr[n][i];
						}
						total = i - num;
						
						if(total>=0) {
							arr[n+1][total] += arr[n][i];
						}
					}
				}
			}
			
			
		}
		
		System.out.print(arr[N-1][Integer.parseInt(input[N-1])]);
		
	}

}
