package beakjoon;

import java.io.*;

public class Baekjoon2293 {

	public static void main(String[] args)throws Exception {
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));

		String[] input = in.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int[] cachs = new int[n];
		int[] arr = new int[k+1];
		for(int i = 0; i<n; i++) {
			int cash = Integer.parseInt(in.readLine());
			cachs[i] = cash;
		}
		
		for(int j = 0; j<n; j++) {
			for(int i = 1; i<k+1; i++) {
				if(i- cachs[j] ==0) {
					arr[i]+=1;
				}else if(i- cachs[j] >0 && arr[i- cachs[j]]>0) {
					arr[i]+=arr[i- cachs[j]];
				}
			}
		}
		
		System.out.println(arr[k]);
		
	}

}
