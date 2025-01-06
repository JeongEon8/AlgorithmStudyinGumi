package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon2096 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int[] save = new int[12];
		String[] input = in.readLine().split(" ");
		save[0] = Integer.parseInt(input[0]);
		save[1] = Integer.parseInt(input[1]);
		save[2] = Integer.parseInt(input[2]);
		save[3] = save[0];
		save[4] = save[1];
		save[5] = save[2];
		save[6] = save[0];
		save[7] = save[1];
		save[8] = save[2];
		save[9] = save[0];
		save[10] = save[1];
		save[11] = save[2];
		for(int n = 1; n<N; n++) {
			input = in.readLine().split(" ");
			int max = Math.max(save[6], save[7]);
			int min =Math.min(save[9], save[10]);
			save[0] = max+Integer.parseInt(input[0]);
			save[1] = Math.max(max, save[8])+Integer.parseInt(input[1]);
			save[2] = Math.max(save[7], save[8])+Integer.parseInt(input[2]);
			save[3] = min+Integer.parseInt(input[0]);
			save[4] = Math.min(min, save[11])+Integer.parseInt(input[1]);
			save[5] = Math.min(save[10], save[11])+Integer.parseInt(input[2]);
			save[6] = save[0];
			save[7] = save[1];
			save[8] = save[2];
			save[9] = save[3];
			save[10] = save[4];
			save[11] = save[5];
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i =0; i<3; i++) {
			if(max< save[i]) {
				max = save[i];
			}
			if(min > save[i+3]) {
				min = save[i+3];
			}
		}
		
		System.out.println(max+" "+min);
	}

}
