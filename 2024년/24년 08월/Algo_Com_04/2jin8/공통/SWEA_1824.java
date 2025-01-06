import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1824 {

	static int R, C, memory;
	static char[][] command;
	static Queue<Point> queue = new ArrayDeque<>();
	static boolean[][][][] visited;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 }; // 오, 왼, 아래, 위

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			command = new char[R][C];
			boolean contain = true;
			for (int i = 0; i < R; i++) {
				String line = br.readLine();
				for (int j = 0; j < C; j++) {
					command[i][j] = line.charAt(j);
					if (command[i][j] == '@')
						contain = true;
				}
			}
			memory = 0;
			visited = new boolean[4][16][R][C]; // 방향 / 메모리값 / x / y
			queue.clear();
			sb.append("#").append(t).append(" ").append(contain ? bfs() : "NO").append("\n"); // '@'가 포함되어 있지 않으면 NO
		}
		System.out.println(sb);
	}

	static String bfs() {
		queue.offer(new Point(0, 0, 0));

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			int x = now.x, y = now.y;
			char c = command[x][y];

			if (c == '@') {
				return "YES";
			} else {
				if (c == '?') { // 방향을 무작위로 (네 방향 모두)
					for (int i = 0; i < 4; i++) {
						addQueue(x + dx[i], y + dy[i], i);
					}
				} else {
					int d = -1;
					switch (c) {
					case '<': // 이동방향을 왼쪽으로 변경
						d = 1;
						break;
					case '>': // 이동방향을 오른쪽으로 변경
						d = 0;
						break;
					case '^': // 이동방향을 위로 변경
						d = 3;
						break;
					case 'v': // 이동방향을 아래로 변경
						d = 2;
						break;
					case '_': // 메모리에 0 저장? 오른쪽 : 왼쪽
						d = memory == 0 ? 0 : 1;
						break;
					case '|': // 메모리에 0 저장? 아래쪽 : 위쪽
						d = memory == 0 ? 2 : 3;
						break;
					case '.': // 아무것도 하지 않음
						d = now.d;
						break;
					case '+': // 메모리에 저장된 값 1 더하기
						if (++memory > 15)
							memory = 0;
						d = now.d;
						break;
					case '-': // 메모리에 저장된 값 1 빼기
						if (--memory < 0)
							memory = 15;
						d = now.d;
						break;
					default: // 0 ~ 9: memory 값 변경
						memory = command[now.x][now.y] - '0';
						d = now.d;
						break;
					}
					addQueue(x + dx[d], y + dy[d], d);
				}
			}
		}
		return "NO";
	}

	static void addQueue(int nx, int ny, int d) {
		// 2차원 격자 바깥으로 이동하면 반대편으로 이동
		if (nx < 0) {
			nx = R - 1;
		} else if (ny < 0) {
			ny = C - 1;
		} else if (nx >= R) {
			nx = 0;
		} else if (ny >= C) {
			ny = 0;
		}

		// 큐에 넣기 전 방문 체크
		if (!visited[d][memory][nx][ny]) {
			queue.offer(new Point(nx, ny, d));
			visited[d][memory][nx][ny] = true;
		}
	}

	static class Point {
		int x, y, d;

		public Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
