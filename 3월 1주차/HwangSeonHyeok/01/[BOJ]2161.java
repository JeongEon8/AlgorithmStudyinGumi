import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Deque<Integer> dq = new ArrayDeque<Integer>();
		for (int i = 1; i <= n; i++) {
			dq.add(i);
		}
		while (!dq.isEmpty()) {
			System.out.print(dq.poll() + " ");
			if (dq.isEmpty())
				break;
			dq.add(dq.poll());
		}

	}

}
