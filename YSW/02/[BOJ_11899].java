import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_11899 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			if (currentChar == ')' && !stack.isEmpty()) {
				if (stack.peek() == '(') {
					stack.pop();
				}else {
					stack.push(currentChar);
				}
			} else {
				stack.push(currentChar);
			}
		}
		
		System.out.println(stack.size());
	}
}