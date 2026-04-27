import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		Stack<Integer> input = new Stack<Integer>();
		for (int i = 0; i < N; i++) {
			input.add(Integer.parseInt(br.readLine()));
		}

		Stack<Integer> st = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int nextPush = 1;
		
		for (int target : input) {
			while (nextPush <= target) {
				st.add(nextPush);
				sb.append("+\n");
				nextPush++;
			}

			if (st.peek() == target) {
				sb.append("-\n");
				st.pop();
			} else {
				sb = new StringBuilder();
				sb.append("NO");
				break;
			}
		}
		
		System.out.println(sb.toString());

	}

}