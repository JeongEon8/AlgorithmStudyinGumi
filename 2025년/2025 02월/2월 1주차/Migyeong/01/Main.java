import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N, M;
	static char map[][];

	static int max;

	static List<int[]> list;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		map = new char[N][M];

		// 입력받기
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		max = 0;

		list = new ArrayList<>();

		int result = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (map[i][j] == 'L')
					result = bfs(i, j);

				if (result > max)
					max = result;
			}
		}
		System.out.println(max);
	}

	private static int bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { x, y, 0 });
		boolean visited[][] = new boolean[N][M];
		visited[x][y] = true;

		int ans = 0;

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int cx = temp[0];
			int cy = temp[1];
			int distance = temp[2];

			ans = Math.max(ans, distance);
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 'L' && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny, distance + 1 });
				}
			}
		}
		return ans;
	}
}