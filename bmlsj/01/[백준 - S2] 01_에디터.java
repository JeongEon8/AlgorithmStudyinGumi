
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

	/*
	 * L : 커서를 왼쪽으로 한칸 R : 커서를 오른쪽으로 한칸 B : 커서 왼쪽 문자 삭제 P $ : $ 라는 문자 왼쪽에 추가
	 */

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();

		// 초기 문자열 => 왼쪽 스택
		for (char c : input.toCharArray()) {
			left.push(c);
		}

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {

			String[] split = br.readLine().split(" ");

			switch (split[0]) {
			case "P": // $ 라는 문자 왼쪽에 추가
				left.push(split[1].charAt(0));
				break;

			case "L": // 커서 왼쪽으로 한칸
				if (!left.isEmpty()) {
					right.push(left.pop());
				}
				break;

			case "D": // 커서를 오른쪽으로 한칸
				if (!right.isEmpty()) {
					left.push(right.pop());
				}
				break;

			case "B": // 커서 왼쪽 문자 삭제
				if (!left.isEmpty()) {
					left.pop();
				}
				break;

			default:
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char l : left) {
			sb.append(l);
		}

		while (!right.isEmpty()) {  // right는 역순으로 출력
			sb.append(right.pop());
		}

		System.out.println(sb.toString());

	}

}
