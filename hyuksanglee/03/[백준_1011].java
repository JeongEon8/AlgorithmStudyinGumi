package beakjoon;

import java.io.*;

public class Baekjoon1011 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		
		for(int t=0; t<T; t++) {
			String [] input = in.readLine().split(" ");
			long x = Integer.parseInt(input[0]);
			long y = Integer.parseInt(input[1]);
			
			long total = y-x;
			long n =(long) Math.sqrt(total);
			// 시간초과뜸
//			int n = 1;
//			while(n*n<=total) {
//				n++;
//			}
//			n--;
			if(n*n==total) {
				System.out.println(2*n-1);
			}else if (n*n+n <total){
				System.out.println(2*n+1);
			}else {
				System.out.println(2*n);
			}
			
			
			
		}
	}

}
