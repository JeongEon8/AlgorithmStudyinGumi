package dp;

import java.io.*;

public class Baekjoon12852 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] arr = new int[N+1];
		int[] save = new int[N+1];
		
		for(int i = 0; i<=N; i++) {
			if(i ==0) {
				arr[i] = 0;
			}else if(i==1) {
				arr[i] = 1;
				save[i] = 1;
			}else if(i==2) {
				arr[i] = 1;
				save[i]=1;
			}else if(i==3) {
				arr[i] = 1;
				save[i] =1;
			}else {
				int min = arr[i-1];
				int index = i-1;
		
				if(i % 2 ==0 && min > arr[i/2] ) {
					min = arr[i/2];
					index = i/2;
				}
				
				if(i % 3 == 0 && min > arr[i/3] ) {
					min = arr[i/3];
					index = i/3;
				}
				
				arr[i]=min+1;
				save[i]= index;
			}
		}
		
		System.out.println(arr[N]);
		int n = N;
		System.out.print(n);
		while(n!=1) {
			n = save[n];
			System.out.print(" "+n);
		}

	}

}
