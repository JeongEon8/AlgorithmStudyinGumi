import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pq.add(Long.parseLong(in.readLine()));
		}
		long ans = 0;
		for (int i = 1; i < n; i++) {
			Long sum = pq.poll() + pq.poll();
			ans += sum;
			pq.add(sum);
		}

		System.out.println(ans);

	}

}