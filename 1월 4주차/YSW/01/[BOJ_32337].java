import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_32337 {
	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long count = 0;
		int[] slopes = new int[M];
		Node[] nodes = new Node[N];
		HashMap<Long, Integer> hashmap = new HashMap<Long, Integer>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			slopes[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			nodes[i] = new Node(x, y);
		}

		for (int i = 0; i < M; i++) {
			int slope = slopes[i];
			for (int j = 0; j < N; j++) {
				int x = nodes[j].x;
				int y = nodes[j].y;
				long b = (long) y - (long) slope * x;
				if (hashmap.containsKey(b)) {
					hashmap.put(b, hashmap.get(b) + 1);
				} else {
					hashmap.put(b, 1);
				}
			}

			for (int n : hashmap.values()) {
				count += (long) n * (long) (n - 1);
			}

			hashmap.clear();
		}

		System.out.println(count);
	}
}