import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_23352 {
	public static int N;
	public static int M;
	public static int[][] map;
	public static int route = 0;
	public static int result = 0;

	public static class info {
		int row;
		int col;
		int move;

		public info(int row, int col, int move) {
			this.row = row;
			this.col = col;
			this.move = move;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			inputs = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					bfs(i, j);
				}
			}
		}

		System.out.println(result);
	}

	private static void bfs(int startRow, int startCol) {
		boolean[][] visited = new boolean[N][M];
		Queue<info> queue = new ArrayDeque<>();
		queue.add(new info(startRow, startCol, 0));
		visited[startRow][startCol] = true;
		int[][] direction = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int start = map[startRow][startCol];

		while (!queue.isEmpty()) {
			info cur = queue.poll();
			int curRow = cur.row;
			int curCol = cur.col;
			int move = cur.move;
			int end = map[cur.row][cur.col];

			if (move >= route) {
				if (move > route) {
					result = start + end;
				} else {
					result = Math.max(result, start + end);
				}
				route = move;
			}

			for (int i = 0; i < direction.length; i++) {
				int nextRow = curRow + direction[i][0];
				int nextCol = curCol + direction[i][1];

				if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && map[nextRow][nextCol] != 0
						&& !visited[nextRow][nextCol]) {
					queue.add(new info(nextRow, nextCol, move + 1));
					visited[nextRow][nextCol] = true;
				}
			}
		}
	}
}