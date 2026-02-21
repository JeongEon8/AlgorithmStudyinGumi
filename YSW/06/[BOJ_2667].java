import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class BOJ_2667 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] inputs;
		int[][] map = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		Queue<int[]> queue = new ArrayDeque<int[]>();
		int[][] direction = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> houseCounts = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			inputs = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					queue.add(new int[] { i, j });
					visited[i][j] = true;
					int houseCount = 0;

					while (!queue.isEmpty()) {
						int[] current = queue.poll();
						int currentRow = current[0];
						int currentCol = current[1];
						houseCount++;

						for (int k = 0; k < 4; k++) {
							int nextRow = currentRow + direction[k][0];
							int nextCol = currentCol + direction[k][1];

							if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && !visited[nextRow][nextCol]
									&& map[nextRow][nextCol] == 1) {
								queue.add(new int[] { nextRow, nextCol });
								visited[nextRow][nextCol] = true;
							}
						}
					}
					houseCounts.add(houseCount);
				}
			}
		}

		Collections.sort(houseCounts);
		sb.append(houseCounts.size()).append("\n");
		for (int i = 0; i < houseCounts.size(); i++) {
			sb.append(houseCounts.get(i)).append("\n");
		}

		System.out.println(sb.toString());
	}
}