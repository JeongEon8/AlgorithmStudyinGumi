package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon2108 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		int total = 0;
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(in.readLine());
			total += num;
			arr[n] = num;
		}

		Arrays.sort(arr);
		int avg = Math.round(total / (float) N);
		System.out.println(avg);
		System.out.println(arr[N / 2]);

		int a = arr[0];
		int back = 0;
		int count = 1;
		int max = 0;
		boolean check = false;
		for (int i = 0; i < N; i++) {
			if(i ==0) {
				back = arr[i];
				max =count;
			}else {
				if(back == arr[i]) {
					count++;
				}else {
					count =1;
					back=arr[i];
				}
				
				if(max<count) {
					max = count;
					a = arr[i];
					check = false;
				}else if(max==count && !check) {
					check =true;
					a = arr[i];
				}
				
			}
		}

		System.out.println(a);
		System.out.println(arr[arr.length - 1] - arr[0]);

	}

}
