import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int dasom = Integer.parseInt(in.readLine());
		int ans = 0;
		if (n > 1) {
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			for (int i = 0; i < n - 1; i++) {
				int num = -Integer.parseInt(in.readLine());
				pq.add(num);
			}

			while (true) {
				int maxVote = -pq.poll();
				if (dasom > maxVote)
					break;
				ans++;
				dasom++;
				pq.add(1 - maxVote);

			}
		}
		System.out.println(ans);

	}

}