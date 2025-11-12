import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 회전하는큐_1021 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);

		Deque<Integer> deque = new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}

		split = br.readLine().split(" ");
		int[] findNum = new int[M];
		for (int i = 0; i < M; i++) {
			findNum[i] = Integer.parseInt(split[i]);
		}

		int idx = 0;
		int ans = 0;
		while (idx < M) {

			int target = findNum[idx];

			int pos = 0;
			for (int n : deque) {
				if (n == target)
					break;
				pos++;
			}

			if (pos <= deque.size() / 2) {
				while (deque.peekFirst() != target) {
					deque.addLast(deque.pollFirst());
					ans++;
				}
			} else {
				while (deque.peekFirst() != target) {
					deque.addFirst(deque.pollLast());
					ans++;
				}
			}
			
			deque.pollFirst();
            idx++;
		}
		

		System.out.println(ans);

	
	}

}
