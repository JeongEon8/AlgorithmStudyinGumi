package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Beakjoon10773 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();

		int K = Integer.parseInt(input.readLine());
		for (int k = 0; k < K; k++) {
			int N = Integer.parseInt(input.readLine());
			if (N == 0) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.add(N);
			}
		}
		int result = 0;
		for (int n : stack) {
			result += n;
		}
		System.out.println(result);

	}

}
