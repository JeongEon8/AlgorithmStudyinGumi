package 그래프;

import java.io.*;

public class Baekjoon1018 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int min = Integer.MAX_VALUE;
		
		String[] list = new String[N];
		for(int n = 0; n<N; n++) {
			list[n] = in.readLine();
		}
		
		for(int i = 0; i<N-7; i++) {
			for(int j = 0; j<M-7; j++) {
				int result =dfs(list, 0, i, j);
				if(min > result) {
					min = result;
				}
				if(min > 64 - result) {
					min = 64 - result;
				}
			}
		}
		
		System.out.println(min);
		
	}
	static int dfs(String[] list, int count, int i, int j) {
		for(int n =i; n< i+8; n++) {
			if(n%2==0) {
				for(int m =j; m<j+8; m++) {
					char c = list[n].charAt(m);
					if(m%2==0 && list[n].charAt(m)!='W') {
						count++;
					}
					if(m%2!=0 && list[n].charAt(m)!='B') {
						count++;
					}
				}
			}else {
				for(int m =j; m<j+8; m++) {
					if(m%2!=0 && list[n].charAt(m)!='W') {
						count++;
					}
					if(m%2==0 && list[n].charAt(m)!='B') {
						count++;
					}			
										
									
				}
			}
		}
		
		return count;
	}
}
