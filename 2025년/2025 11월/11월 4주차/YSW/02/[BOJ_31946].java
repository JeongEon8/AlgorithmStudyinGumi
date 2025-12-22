import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_31946 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] grid = new int[N + 1][M + 1];
		boolean[][] visited = new boolean[N + 1][M + 1];
		int X = 0;
		Queue<int[]> queue = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				grid[i + 1][j + 1] = Integer.parseInt(inputs[j]);
			}
		}

		X = Integer.parseInt(br.readLine());
		queue.add(new int[] { 1, 1 });
		visited[1][1] = true;
		int startBlock = grid[1][1];

		while (!queue.isEmpty()) {
			int[] currentPos = queue.poll();
			int curRow = currentPos[0];
			int curCol = currentPos[1];
			if (curRow == N && curCol == M) {
				System.out.println("ALIVE");
				return;
			}

			for (int i = -X; i <= X; i++) {
				int remin = X - Math.abs(i);

				for (int j = -remin; j <= remin; j++) {
					int nextRow = curRow + i;
					int nextCol = curCol + j;

					if (nextRow >= 1 && nextRow <= N && nextCol >= 1 && nextCol <= M && !visited[nextRow][nextCol]
							&& grid[nextRow][nextCol] == startBlock) {
						queue.add(new int[] { nextRow, nextCol });
						visited[nextRow][nextCol] = true;
					}
				}
			}
		}

		System.out.println("DEAD");
	}
}