import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char yard[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static boolean visited[][];
	static int sheep, wolf;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		yard = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				yard[i][j] = input.charAt(j);
			}
		}

		int totalSheep = 0, totalWolf = 0;

//		ArrayList<Integer> areas = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (yard[i][j] == 'v' && yard[i][j] == 'o' || !visited[i][j]) {
					sheep = 0;
					wolf = 0;
					bfs(i, j);
					
					if(sheep > wolf) {
						totalSheep += sheep;
					} else {
						totalWolf += wolf;
					}
				}
			}
		}
		System.out.println(totalSheep + " " + totalWolf);

	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		visited[x][y] = true;

		if(yard[x][y] == 'o') sheep++;
		if(yard[x][y] == 'v') wolf++;

		while (!queue.isEmpty()) {
			int current[] = queue.poll();
			int cx = current[0];
			int cy = current[1];

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny] == true || yard[nx][ny] == '#') {
					continue;
				}

				queue.offer(new int[] { nx, ny });
				visited[nx][ny] = true;

				if (yard[nx][ny] == 'o') {
					sheep++;
				}
				if (yard[nx][ny] == 'v') {
					wolf++;
				}

			}

		}
	}
}