package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1339 {

	public static void main(String[] args)throws Exception {
		
		BufferedReader in = new BufferedReader( new InputStreamReader( System.in));
		
		int N  = Integer.parseInt(in.readLine());
		
		int[] num = new int[26];
		
		for(int n = 0; n<N; n++) {
			String input = in.readLine();
				
			int weight = 1;
			for (int i = 0 ; i< input.length()-1; i++) {
				weight *= 10;
			}
			
			for(int l = 0; l< input.length(); l++) {
				char c = input.charAt(l);
				num[c-'A'] += weight;
				
				weight /= 10;
			}
		}
		
		Arrays.sort(num);
		int total = 0;
		int point = 9;
		for(int i = 25; i>=0; i--) {
			total += num[i] * point ;
			point--;
			if(point <=0) {
				break;
			}
		}
		
		System.out.print(total);
		

	}

}
