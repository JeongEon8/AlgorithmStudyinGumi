package 그래프;

import java.io.*;

public class Baekjoon1057 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int A = Integer.parseInt(input[1]);
		int B = Integer.parseInt(input[2]);
		int result = 0;
		
		while(A!=B) {
			A = (A+1)/2;
			B= (B+1)/2;
			result ++;
		}
		
		System.out.print(result);

	}
	
	

}
