import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;
	static HashSet<Node> nodes;
	static boolean[][] map;

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof Node))
				return false;
			Node n = (Node) o;
			return x == n.x && y == n.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		nodes = new HashSet<>();
		map = new boolean[101][101];
		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			int x = Integer.parseInt(split[0]);
			int y = Integer.parseInt(split[1]);
			int d = Integer.parseInt(split[2]);
			int g = Integer.parseInt(split[3]);

			move(x, y, d, g);
		}

		for (Node node : nodes) {
			map[node.x][node.y] = true;
		}

		System.out.println(square());

	}

	static int square() {

		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
					cnt++;
				}
			}
		}

		return cnt;
	}

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static void move(int x, int y, int d, int g) {

		List<Integer> dirs = new ArrayList<Integer>();
		dirs.add(d);

		for (int i = 0; i < g; i++) {
			for (int j = dirs.size() - 1; j >= 0; j--) {
				dirs.add((dirs.get(j) + 1) % 4);
			}
		}

		// System.out.println(dirs);
		// dirs의 좌표 이동
		map[x][y] = true;
		for (int dir : dirs) {
			x += dx[dir];
			y += dy[dir];

			nodes.add(new Node(x, y));
		}

	}

}
