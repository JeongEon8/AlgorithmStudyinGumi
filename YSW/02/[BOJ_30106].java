import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_30106 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);
		int K = Integer.parseInt(inputs[2]);
		int[][] room = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> queue = new ArrayDeque<>();
		int[][] move = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		for (int i = 0; i < N; i++) {
			inputs = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(inputs[j]);
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					queue.add(new int[] { i, j });
					visited[i][j] = true;
					count++;
				}

				while (!queue.isEmpty()) {
					int[] current = queue.poll();
					int currentRow = current[0];
					int currentCol = current[1];

					for (int k = 0; k < 4; k++) {
						int moveRow = currentRow + move[k][0];
						int moveCol = currentCol + move[k][1];
						if (!(moveRow >= 0 && moveRow < N && moveCol >= 0 && moveCol < M)) {
							continue;
						}
						int diff = room[currentRow][currentCol] - room[moveRow][moveCol];

						if (!visited[moveRow][moveCol] && Math.abs(diff) <= K) {
							queue.add(new int[] { moveRow, moveCol });
							visited[moveRow][moveCol] = true;
						}
					}
				}
			}
		}

		System.out.println(count);
	}
}