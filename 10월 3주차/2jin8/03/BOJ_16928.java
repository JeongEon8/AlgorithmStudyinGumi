import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16928 {

	static final int MAX = 100;
	static boolean[] visited;
	static HashMap<Integer, Integer> ladder, snake;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ladder = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ladder.put(x, y);
		}

		snake = new HashMap<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			snake.put(x, y);
		}

		visited = new boolean[MAX + 1];
		bfs(1);
	}

	static void bfs(int x) {
		// [0]: 좌표, [1]: 거리
		PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[1], p2[1]));
		pq.offer(new int[] { x, 0 });
		visited[x] = true;

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			if (now[0] == MAX) {
				System.out.println(now[1]);
				break;
			}

			// 주사위 수: 1 ~ 6
			for (int i = 1; i <= 6; i++) {
				int next = now[0] + i;
				if (next <= MAX && !visited[next]) {
					visited[next] = true;
					if (ladder.containsKey(next)) {
						int newNext = ladder.get(next);
						pq.offer(new int[] { newNext, now[1] + 1 });
						visited[newNext] = true;
					} else if (snake.containsKey(next)) {
						int newNext = snake.get(next);
						pq.offer(new int[] { newNext, now[1] + 1 });
						visited[newNext] = true;
					} else {
						pq.offer(new int[] { next, now[1] + 1 });
					}
				}
			}
		}
	}
}
