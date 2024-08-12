package HongJun.08_[SWEA]1218;

public class SWEA_1218 {
    public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c=='(' || c=='[' || c=='{' || c=='<') {
				stack.push(c);
			}
			else if (c==')' || c==']' || c=='}' || c=='>') {
				if (stack.isEmpty())
					return false;
				char open = stack.pop();
				
				boolean isMatch = isMatchCheck(open, c);
				if (isMatch == false)
					return false;
			}
		}

		return stack.isEmpty();
	}
	
	private static boolean isMatchCheck(char open, char close) {
		return (open == '(' && close == ')' ||
				open == '[' && close == ']' ||
				open == '{' && close == '}' ||
				open == '<' && close == '>');
	}


	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//System.setIn(new FileInputStream("1218_input.txt"));
		
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#" + test_case + " ");
			int n = Integer.parseInt(br.readLine());
			
			String s = br.readLine();
			
			boolean result = isValid(s);
			if (result) {
				sb.append("1" + "\n");
			} else {
				sb.append("0" + "\n");
			}
		}
		System.out.println(sb);
		
	}
}
