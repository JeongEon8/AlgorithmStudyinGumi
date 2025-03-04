import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {
	static int R, C;
	static char map[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int min;

	static int Sx, Sy;

	static int count[][];
	static int INF = Integer.MAX_VALUE;

	static boolean result;
	
	static Queue<int[]> water = new ArrayDeque<int[]>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");
		R = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);
		map = new char[R][C];

		count = new int[R][C];
		
		// 비어 있는 곳 .
		// 물이 차 있는 지역 *
		// 돌은 X
		// 비버의 굴 D
		// 고슴도치의 위치 S
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'S') { // 고슴도치 위치
					Sx = i;
					Sy = j;
				}
				if (map[i][j] == '*') { // 물이 차 있는 곳 좌표
					water.offer(new int[] { i, j });
				}
			}
		}

		result = false;
		min = Integer.MAX_VALUE;

		bfs(Sx, Sy);

		if (!result) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(min);
		}

	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { x, y, 0 });

		while (!queue.isEmpty()) {

			int w = water.size();

			// 물이 퍼지는 곳
			for (int i = 0; i < w; i++) {
				int[] temp = water.poll();
				int wx = temp[0];
				int wy = temp[1];
				for (int j = 0; j < 4; j++) {
					int nwx = wx + dx[j];
					int nwy = wy + dy[j];
					if (nwx >= 0 && nwx < R && nwy >= 0 && nwy < C && map[nwx][nwy] == '.') {
						map[nwx][nwy] = '*';
						water.offer(new int[] { nwx, nwy });
					}
				}
			}

			// 고슴도치 이동
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] temp = queue.poll();
				int curX = temp[0];
				int curY = temp[1];
				int cnt = temp[2];

				for (int j = 0; j < 4; j++) {
					int nx = curX + dx[j];
					int ny = curY + dy[j];

					if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
						if (map[nx][ny] == 'D') {
							min = Math.min(min, cnt + 1);
							result = true;
							return;
						} else if (map[nx][ny] == '.') {
							map[nx][ny] = 'S';
							queue.offer(new int[] { nx, ny, cnt + 1 });
						}
					}

				}
			}
		}

	}
}
