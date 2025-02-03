package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon10972 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		String[] input = in.readLine().split(" ");
		int [] num = new int[input.length];
		for(int i = 0; i<input.length; i++) {
			num[i] = Integer.parseInt(input[i]);
		}
		
	
				int idx = N - 1;
				while (idx > 0 && num[idx - 1] > num[idx]) {
					idx--;
				}

				if (idx == 0) {
					System.out.println(-1);
					return;
				}

				
				int big_idx = N - 1;
				while (big_idx > idx && num[idx - 1] > num[big_idx]) {
					big_idx--;
				}

			
				int temp = num[idx - 1];
				num[idx - 1] = num[big_idx];
				num[big_idx] = temp;

				Arrays.sort(num, idx, N);
				
				for(int i = 0; i< num.length; i++) {
					System.out.print(num[i]+" ");
				}
				
	}

}

