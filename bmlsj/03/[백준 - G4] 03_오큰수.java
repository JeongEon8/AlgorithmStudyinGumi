import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		int[] nums = new int[N];
		int[] result = new int[N];
		Arrays.fill(result, -1);

		String[] split = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(split[i]);
		}

		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				result[stack.pop()] = nums[i];
			}

			stack.push(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int re : result) {
			sb.append(re).append(" ");
		}

		System.out.println(sb);

	}

}