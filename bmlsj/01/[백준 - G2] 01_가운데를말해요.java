
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> right = new PriorityQueue<>(); // 최소 힙(중간 값 이하)
		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙

		for (int i = 0; i < N; i++) {

			int input = Integer.parseInt(br.readLine());
			if (left.isEmpty() || left.peek() >= input) { // input 이 더 작을 경우
				left.offer(input);
			} else {
				right.offer(input);
			}

			// 크기 조절
			if (left.size() > right.size() + 1) {
				right.add(left.poll());
			}

			if (right.size() > left.size()) {
				left.add(right.poll());
			}

			System.out.println(left.peek());
		}

	}

}
