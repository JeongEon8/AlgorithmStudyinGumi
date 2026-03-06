import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M, T;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);

		PriorityQueue<Long> cards = new PriorityQueue<>();

		split = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			cards.add(Long.parseLong(split[i]));
		}

		for (int t = 0; t < m; t++) {

			if (cards.size() >= 2) {
				Long a = cards.poll();
				Long b = cards.poll();
				
				cards.add(a + b);
				cards.add(a + b);
			}

		}
		
		long ans = 0;
		for(long card: cards) {
			ans += card;
		}
		
		System.out.println(ans);

	}

}