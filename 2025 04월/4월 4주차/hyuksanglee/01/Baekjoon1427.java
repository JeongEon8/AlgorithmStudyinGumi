package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Baekjoon1427 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input  = in.readLine().split("");
		Arrays.sort(input);
	
		for(int i =0; i<input.length;i++) {
			System.out.print(input[input.length-i-1]);
		}
		

	}

}
