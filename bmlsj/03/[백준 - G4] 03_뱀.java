import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main {

	static int N, K, L;
	static int[][] map;

	public static class Node {
		int X;
		String dir;

		public Node(int X, String dir) {
			this.X = X;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine()); // 사과 위치

		map = new int[N][N];
		for (int i = 0; i < K; i++) {
			String[] split = br.readLine().split(" ");
			int x = Integer.parseInt(split[0]) - 1;
			int y = Integer.parseInt(split[1]) - 1;

			map[x][y] = 1;
		}

		L = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 횟수

		Queue<Node> commands = new ArrayDeque<>();
		for (int i = 0; i < L; i++) {
			String[] split = br.readLine().split(" ");
			int X = Integer.parseInt(split[0]); // 초
			String C = split[1]; // 방향 L or D로 90도 회전

			commands.add(new Node(X, C));
		}

		Deque<int[]> snake = new ArrayDeque<>();
		int time = 0, dir = 0;

		snake.add(new int[] { 0, 0 });
		while (true) {

			time++;

			// 뱀 이동
			boolean check = move(snake, dir);
			
			if(!check) break;

			// 방향 전환
			if (!commands.isEmpty() && commands.peek().X == time) {
				Node cmd = commands.poll();
				if (cmd.dir.equals("L")) {
					dir = (dir + 3) % 4;
				} else {
					dir = (dir + 1) % 4;
				}
			}
		}
		
		System.out.println(time);
		
	}

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 }; // 우, 하, 좌, 상

	public static boolean move(Deque<int[]> snake, int dir) {

		int[] curr = snake.peekLast();
		int x = curr[0] + dx[dir];
		int y = curr[1] + dy[dir];

		if (x < 0 || y < 0 || x >= N || y >= N) { // 벽
//			System.out.println("벽");
			return false;
		}

		// 자기자신
		for (int[] body : snake) {
			if (body[0] == x && body[1] == y) {
//				System.out.println("나");
				return false;
			}
		}

		if (map[x][y] == 1) { // 사과 일때
			map[x][y] = 0;
			snake.add(new int[] { x, y });
		} else { // 사과 아닐때
			snake.poll();
			snake.add(new int[] { x, y });
		}
		
		return true;
	}

}
