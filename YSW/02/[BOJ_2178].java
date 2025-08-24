import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_2178 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		int N = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		int[][] move = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		Queue<int[]> queue = new ArrayDeque<int[]>();
		int result = 0;

		for (int i = 0; i < N; i++) {
			strArr = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(strArr[j]);
			}
		}

		queue.offer(new int[] { 0, 0, 1 });
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentRow = current[0];
			int currentCol = current[1];
			int count = current[2];

			if (currentRow == N - 1 && currentCol == M - 1) {
				result = count;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int moveRow = currentRow + move[i][0];
				int moveCol = currentCol + move[i][1];

				if (moveRow >= 0 && moveRow < N && moveCol >= 0 && moveCol < M && !visited[moveRow][moveCol]
						&& map[moveRow][moveCol] == 1) {
					queue.offer(new int[] { moveRow, moveCol, count + 1 });
					visited[moveRow][moveCol] = true;
				}
			}
		}

		System.out.println(result);
	}
}