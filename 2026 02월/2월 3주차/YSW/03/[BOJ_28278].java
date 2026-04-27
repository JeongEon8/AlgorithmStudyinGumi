import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_28278 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == 1) {
				int x = Integer.parseInt(st.nextToken());
				stack.push(x);
			} else if (command == 2) {
				if (stack.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(stack.pop()).append("\n");
				}
			} else if (command == 3) {
				sb.append(stack.size()).append("\n");
			} else if (command == 4) {
				sb.append(stack.isEmpty() ? 1 : 0).append("\n");
			} else if (command == 5) {
				sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}