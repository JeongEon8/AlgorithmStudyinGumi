package beakjoon;

import java.io.*;
import java.util.*;
public class Baekjoon2143 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		
		int N = Integer.parseInt(in.readLine());
		String[] input = in.readLine().split(" ");
		
		Map<Integer, Integer> sumA = new HashMap<>();
		
		int[] A = new int [N];
		for(int n=0; n<N; n++) {
			A[n] = Integer.parseInt(input[n]);
		}
		
		for(int n =0; n<N; n++) {
			int sum = 0;
			for(int m = n; m<N; m++) {
				sum+=A[m];
				sumA.put(sum, sumA.getOrDefault(sum, 0)+1);
			}
		}
		
		N = Integer.parseInt(in.readLine());
		
		input = in.readLine().split(" ");
		int[] B = new int[N];
		for(int n=0; n<N; n++) {
			B[n] = Integer.parseInt(input[n]);
		}
		
		int count =0;
		for(int n =0; n<N; n++) {
			int sum =0;
			for(int m = n; m<N; m++) {
				sum+= B[m];
				int t = T-sum;
				count += sumA.getOrDefault(t, 0);
			}
			
		}
		
		
		System.out.println(count);
			
	}


}
