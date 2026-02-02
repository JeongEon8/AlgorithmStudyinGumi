package 시뮬레이션;

import java.io.*;

public class Baekjoon14719 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input= in.readLine().split(" ");
		int H = Integer.parseInt(input[0]);
		int W = Integer.parseInt(input[1]);
		
		input= in.readLine().split(" ");
		int[] arr = new int[W];
		int total = 0;
		
		for(int w = 0; w<W; w++) {
			int n = Integer.parseInt(input[w]);
			arr[w] = n;
			
		}

		for (int i = 1; i < W - 1; i++) {
            int l = 0;
            int r = 0;

            
            for (int j = 0; j <= i; j++) {
                l = Math.max(l, arr[j]);
            }

          
            for (int j = i; j < W; j++) {
                r = Math.max(r, arr[j]);
            }

           
            int min = Math.min(l, r);
            
          
            total += (min - arr[i]);
        }
		System.out.println(total);
	}

}
