package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_10726 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		for(int t =1; t<= TC; t++) {
			String[] input = in.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			
			int num = 0;
			for(int n =0; n<N; n++) {
			num =num <<1;
			num = num+1;
			}
			String str = "OFF";
			if((num& M) == num) {
				str = "ON";
			}
			System.out.println("#"+t+" "+str);
		}

	}

}
