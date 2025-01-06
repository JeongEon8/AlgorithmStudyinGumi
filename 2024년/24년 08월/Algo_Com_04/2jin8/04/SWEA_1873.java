import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873 {

	static int H, W, x, y;
	static char[][] map;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static char[] direction = { '^', 'v', '<', '>' };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// . 평지 / * 벽돌 / # 강철 / - 물
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String line = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);
					// 전차의 초기 위치 찾기
					if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == 'v' || map[i][j] == '^') {
						x = i;
						y = j;
					}
				}
			}

			int N = Integer.parseInt(br.readLine()); // 입력의 개수
			String cmd = br.readLine();
			for (int i = 0; i < N; i++) {
				switch (cmd.charAt(i)) {
				case 'U': // 위로 이동
					move(0);
					break;
				case 'D': // 아래로 이동
					move(1);
					break;
				case 'L': // 왼쪽으로 이동
					move(2);
					break;
				case 'R': // 오른쪽으로 이동
					move(3);
					break;
				case 'S': // 포탄 발사
					char d = map[x][y];
					if (d == '^')
						shoot(-1, 0);
					else if (d == 'v')
						shoot(1, 0);
					else if (d == '<')
						shoot(0, -1);
					else if (d == '>')
						shoot(0, 1);
					break;
				}
			}

			sb.append("#").append(t).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	static void move(int d) {
		map[x][y] = direction[d]; // 바라보는 방향 변경하기

		int nx = x + dx[d], ny = y + dy[d];
		// 이동하려는 곳이 범위를 벗어나면 종료
		if (nx < 0 || ny < 0 || nx >= H || ny >= W)
			return;

		if (map[nx][ny] == '.') { // 이동하려는 곳이 평지면 이동
			map[nx][ny] = map[x][y];
			map[x][y] = '.';
			x = nx;
			y = ny;
		}
	}

	// 포탄을 쏘는 방향을 정했으면 해당 방향으로 쏘기
	static void shoot(int dx, int dy) {
		int sx = x, sy = y;
		while (true) {
			sx += dx;
			sy += dy;

			// 범위를 벗어나면 종료
			if (sx < 0 || sy < 0 || sx >= H || sy >= W)
				break;

			if (map[sx][sy] == '*') { // 부딪힌 곳이 벽돌 벽이라면 부숴짐
				map[sx][sy] = '.';
				break;
			} else if (map[sx][sy] == '#') { // 부딪힌 곳이 강철 벽이라면 아무일도 일어나지 않음
				break;
			}
		}
	}
}
