import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static boolean isOp(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}


	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();
		long[] num = { 0, 0 };
		boolean[] isMinus = new boolean[2];
		int idx = 0;
		char op = ' ';
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (i == 0 && c == '-') {
				isMinus[0] = true;
			} else if (c == '-' && isOp(input.charAt(i - 1))) {
				isMinus[1] = true;
			} else if (isOp(c)) {
				op = c;
				idx++;
			} else {
				num[idx] *= 8;
				num[idx] += c - '0';
			}
		}
		num[0] = isMinus[0] ? -num[0] : num[0];
		num[1] = isMinus[1] ? -num[1] : num[1];
		long ans = 0;
		boolean isError = false;
		switch (op) {
		case '+': {
			ans = num[0] + num[1];
			break;
		}
		case '-': {
			ans = num[0] - num[1];
			break;
		}
		case '*': {
			ans = num[0] * num[1];

			break;
		}
		case '/': {
			if (num[1] == 0) {
				isError = true;
				break;
			}
			ans = Math.floorDiv(num[0], num[1]);
			break;
		}
		}
		if (isError) {
			System.out.println("invalid");
		} else {
			System.out.println(Long.toString(ans, 8));
		}

	}

}