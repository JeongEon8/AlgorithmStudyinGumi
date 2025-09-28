import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[] s;

	static class Pair {
		int length, idx;

		public Pair(int length, int idx) {
			this.length = length;
			this.idx = idx;
		}

	}

	static Pair calculate(int idx) {
		int length = 0;
		for (int i = idx; i < s.length; i++) {
			char current = s[i];
			if (current == '(') {
				int mult = s[i - 1] - '0';
				Pair p = calculate(i + 1);
				length += p.length * mult - 1;
				i = p.idx;
			} else if (current == ')') {
				return new Pair(length, i);
			} else {
				length++;
			}
		}
		return new Pair(length, s.length - 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		s = in.readLine().toCharArray();
		Pair ans = calculate(0);
		System.out.println(ans.length);

	}

}