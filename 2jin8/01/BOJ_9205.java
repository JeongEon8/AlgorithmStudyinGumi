import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {

	static int N, M;
	static Point[] points;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine()); // 편의점의 개수
			M = N + 2; 

			visited = new boolean[M];
			points = new Point[M];
			for (int i = 0; i < M; i++) {
				// i = 0일 때: 상근이 위치, i = M - 1일 때: 페스티벌 위치
				st = new StringTokenizer(br.readLine());
				points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			sb.append(bfs(0, M - 1)).append("\n");
		}
		System.out.println(sb);
	}

	static String bfs(int start, int end) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(points[start]);
		visited[start] = true;

		Point endPoint = points[end];
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			// 페스티벌에 도착한 경우
			if (now.x == endPoint.x && now.y == endPoint.y)
				return "happy";

			for (int i = 1; i < M; i++) {
				Point next = points[i];
				int dist = Math.abs(now.x - next.x) + Math.abs(now.y - next.y);
				if (!visited[i] && dist <= 1000) {
					visited[i] = true;
					queue.offer(next);
				}
			}
		}
		return "sad";
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
