package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1918 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();

		StringBuilder result = new StringBuilder();
		Stack<Character> si = new Stack<>();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (c >= 'A' && c <= 'Z') {
				result.append(c);
			} else if (c == '(') {
				si.push(c);
			} else if (c == ')') {
				while (!si.isEmpty() && si.peek() != '(') {
					result.append(si.pop());
				}
				if (!si.isEmpty()) si.pop(); 
			} else { 
				while (!si.isEmpty() && precedence(si.peek()) >= precedence(c)) {
					if (si.peek() == '(') break;
					result.append(si.pop());
				}
				si.push(c);
			}
		}

		while (!si.isEmpty()) {
			result.append(si.pop());
		}

		System.out.println(result.toString());
	}

	private static int precedence(char op) {
		if (op == '+' || op == '-') return 1;
		if (op == '*' || op == '/') return 2;
		return 0;
	}
}
