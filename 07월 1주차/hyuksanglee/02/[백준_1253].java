package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1253 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		String[] input = in.readLine().split(" ");
		int[] nums = new int[N];
		for(int n = 0; n<N; n++) {
			nums[n] = Integer.parseInt(input[n]);
		}
		
		Arrays.sort(nums);
		int count =0;
		for(int n = 0; n<N; n++) {
			int num = nums[n];
			
			int l = 0;
			int r = N-1;
			
			while(l<r) {
				if(l == n) {
					l++;
					continue;
				}
				else if(r ==n) {
					r--;
					continue;
				}
				
				int sum = nums[l]+ nums[r];
				
				if(sum == num) {
					count++;
					break;
				}
				if(sum>num) {
					r--;
				}
				else {
					l++;
				}
			}
			
		}
		
		System.out.println(count);

	}

}
