import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

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
			Node node = (Node) o;
			return x == node.x && y == node.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}

	static HashSet<Node> allPoints;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		allPoints = new HashSet<>();
		for (int t = 0; t < N; t++) {
			String[] split = br.readLine().split(" ");
			int x = Integer.parseInt(split[0]);
			int y = Integer.parseInt(split[1]);
			int d = Integer.parseInt(split[2]); // 시작 방향
			int g = Integer.parseInt(split[3]); // 세대

			curve(x, y, d, g);
		}

		int ans = 0;
		for (Node node : allPoints) {
			// System.out.println(node.x + " " + node.y);
			if (countSquare(node)) {
				ans++;
			}

		}

		System.out.println(ans);

	}

	static boolean countSquare(Node node) {

		int[] dx = { 1, 0, 1 };
		int[] dy = { 0, 1, 1 };

		// System.out.println(node.x + " " + node.y);
		for (int i = 0; i < 3; i++) {
			int nx = node.x + dx[i];
			int ny = node.y + dy[i];

			if (!allPoints.contains(new Node(nx, ny))) {
				return false;
			}
		}

		return true;

	}

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static void curve(int x, int y, int d, int g) {
		ArrayList<Integer> dirs = new ArrayList<Integer>();
		dirs.add(d);

		for (int gen = 0; gen < g; gen++) {
			for (int i = dirs.size() - 1; i >= 0; i--) {
				dirs.add((dirs.get(i) + 1) % 4);
			}
		}

		allPoints.add(new Node(x, y));
		for (int dir : dirs) {
			x += dx[dir];
			y += dy[dir];

			allPoints.add(new Node(x, y));
		}

	}

}