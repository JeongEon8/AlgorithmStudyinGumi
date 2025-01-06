package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon14567 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] input = in.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		ArrayList<Integer>[] arr = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int m = 0; m < M; m++) {
			input = in.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);

			arr[B].add(A);
		}

		int[] result = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if (!arr[i].isEmpty()) {
				int max = Integer.MIN_VALUE;
				for (int n : arr[i]) {
					if (max < result[n]) {
						max = result[n];
					}
				}
				result[i] = 1+max;
			} else {
				result[i] = 1;
			}
			System.out.print(result[i] + " ");

		}
		
		

	}

}
