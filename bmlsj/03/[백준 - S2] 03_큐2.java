import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			String comm = split[0];
			if (split.length == 1) {
				switch (comm) {
				case "back": {
					if (!queue.isEmpty()) {
						sb.append(queue.peekLast()).append('\n');
					} else {
						sb.append("-1").append('\n');
					}
				}
					break;
				case "size": {
					sb.append(queue.size()).append('\n');
					break;
				}
				case "empty": {
					if (!queue.isEmpty()) {
						sb.append("0").append('\n');
					} else {
						sb.append("1").append('\n');
					}
				}
					break;
				case "pop": {
					if (!queue.isEmpty()) {
						sb.append(queue.pop()).append('\n');
					} else {
						sb.append("-1").append('\n');
					}
					break;
				}
				case "front": {
					if (!queue.isEmpty()) {
						sb.append(queue.peekFirst()).append('\n');
					} else {
						sb.append("-1").append('\n');
					}
					break;
				}
				}
			} else {
				int X = Integer.parseInt(split[1]);
				queue.add(X);
			}
		}

		System.out.print(sb);

	}

}