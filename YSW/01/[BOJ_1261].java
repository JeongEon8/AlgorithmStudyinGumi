import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261 {
	public static class Point implements Comparable<Point> {
		int row;
		int col;
		int count;

		public Point(int row, int col, int count) {
			this.row = row;
			this.col = col;
			this.count = count;
		}

		@Override
		public int compareTo(Point other) {
			return this.count - other.count;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] maze = new int[N][M];
		PriorityQueue<Point> queue = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][M];
		queue.add(new Point(0, 0, 0));
		visited[0][0] = true;
		int[][] direction = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = input.charAt(j) - '0';
			}
		}

		while (!queue.isEmpty()) {
			Point curr = queue.poll();
			int currRow = curr.row;
			int currCol = curr.col;
			int currCount = curr.count;

			if (currRow == N - 1 && currCol == M - 1) {
				System.out.println(currCount);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nextRow = currRow + direction[i][0];
				int nextCol = currCol + direction[i][1];
				if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && !visited[nextRow][nextCol]
						&& maze[nextRow][nextCol] == 0) {
					queue.add(new Point(nextRow, nextCol, currCount));
					visited[nextRow][nextCol] = true;
				}

				if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && !visited[nextRow][nextCol]
						&& maze[nextRow][nextCol] == 1) {
					queue.add(new Point(nextRow, nextCol, currCount + 1));
					visited[nextRow][nextCol] = true;
				}
			}
		}
	}
}