import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static class Card implements Comparable<Card> {
		public Card(int value, int index) {
			this.value = value;
			this.index = index;
		}

		int value, index;

		@Override
		public int compareTo(Card o) {
			return this.value - o.value;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		PriorityQueue<Card> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(in.readLine());
			pq.add(new Card(value, i));
		}
		int ans = 0;
		Card current = pq.poll();
		while (!pq.isEmpty()) {
			Card next = pq.poll();
			if (current.index > next.index) {
				ans++;
			}
			current = next;
		}
		System.out.println(ans);
	}

}