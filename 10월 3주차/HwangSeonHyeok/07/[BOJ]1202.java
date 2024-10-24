import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	static class Jewel implements Comparable<Jewel> {
		long weight, value;

		public Jewel(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}

		@Override
		public int compareTo(Jewel o) {
			return (int) (this.weight - o.weight);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		Jewel[] jArray = new Jewel[n];
		for (int i = 0; i < n; i++) {
			split = in.readLine().split(" ");
			int weight = Integer.parseInt(split[0]);
			int value = Integer.parseInt(split[1]);
			jArray[i] = new Jewel(weight, value);

		}
		int[] bp = new int[m];
		for (int i = 0; i < m; i++) {
			bp[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(jArray);
		Arrays.sort(bp);
		int bpidx = 0;
		long ans = 0;
		PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				return (int) (o2 - o1);
			}
		});
		for (int i = 0; i < n; i++) {
			if (bp[bpidx] < jArray[i].weight) {
				while (bpidx < m && bp[bpidx] < jArray[i].weight) {
					if (!pq.isEmpty()) {
						ans += pq.poll();
					}
					bpidx++;
				}
				if (bpidx == m)
					break;
			}
			pq.add(jArray[i].value);

		}
		while (bpidx < m && !pq.isEmpty()) {
			ans += pq.poll();
			bpidx++;
		}

		System.out.println(ans);

	}

}