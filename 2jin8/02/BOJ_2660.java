import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2660 {

	static int N;
	static int[] minDist, dist;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dist = new int[N + 1];
		minDist = new int[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		StringTokenizer st = null;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1)
				break;
			// 양방향
			graph[a].add(b);
			graph[b].add(a);
		}

		int min = Integer.MAX_VALUE;
		ArrayList<Integer> minList = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist, 0);
			minDist[i] = bfs(i);
			if (min > minDist[i]) {
				minList.clear();
				minList.add(i);
				min = minDist[i];
			} else if (min == minDist[i]) {
				minList.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(min).append(" ").append(minList.size()).append("\n");
		for (int m : minList) {
			sb.append(m).append(" ");
		}
		System.out.println(sb);
	}

	static int bfs(int x) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(x);
		dist[x] = 1; // 방문 처리를 위해 1로 표시 (원래 0)

		int max = 0;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			max = Math.max(max, dist[now]); // 모두 연결되어 있으니 여기서 최댓값 찾기

			for (int next : graph[now]) {
				if (dist[next] == 0) {
					queue.offer(next);
					dist[next] = dist[now] + 1;
				}
			}
		}
		return max - 1; // 처음 위치에 1을 더해줬으니 최종값은 1을 빼야 함
	}
}
