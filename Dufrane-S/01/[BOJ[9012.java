import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean check = true;
		for (int i = 0; i < n; i++) {
			check = true;
			String s = br.readLine();
			Stack<Character> st = new Stack<>();
			for (int j = 0; j < s.length(); j++) {
				if (!check)
					break;
				char now = s.charAt(j);
				if (now == ')') {
					if (!st.isEmpty()) {
						st.pop();
					} else {
						check = false;
					}

				} else if (now == '(') {
					st.push(now);
				}

			}
			if (!st.isEmpty()) {
				check = false;
			}
			if (!check) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}
