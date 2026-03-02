package 시뮬레이션;

import java.io.*;

public class Baekjoon20055 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		int result =0;
		int count =0;
		
		int[] arr = new int[2*N];
		boolean[] check = new boolean[2*N];
		input =in.readLine().split(" ");
		for(int i =0; i<2*N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		while(count<K) {
			result++;
			
			boolean temN = check[2*N-1];
			for(int i =2*N-1; i>0; i--) {
				check[i]=check[i-1];
			}
			check[0]= temN;
			
			int temM = arr[2*N-1];
			for(int i =2*N-1; i>0; i--) {
				arr[i]=arr[i-1];
			}
			arr[0]= temM;
			
			check[0]=false;
			check[N-1]=false;
			
			for(int i =N-2; i>=0; i--) {
				if( check[i] && check[i+1]==false && arr[i+1]>0) {
					check[i]=false;
					check[i+1]=true;
					arr[i+1]--;
				}
				check[N-1]=false;
			}
			
			
			if(arr[0]>0) {
				arr[0]--;
				check[0] = true;
			}
			
			 count =0;
			 for (int i = 0; i < 2 * N; i++) {
	                if (arr[i] == 0) {
	                    count++;
	                }
	            }
			
			
		}
		
		System.out.print(result-1);

	}

}
