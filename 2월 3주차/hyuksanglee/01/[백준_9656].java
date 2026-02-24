package 수학;

import java.io.*;

public class Baekjoon9656 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		String result = "CY";
		
		if(N %2==0) {
			result = "SK";
		}
		System.out.println(result);
	}

}
