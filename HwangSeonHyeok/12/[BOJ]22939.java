import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static Point home;
	static Point dest;
	static List<Point> jList = new ArrayList<Point>();// 3
	static List<Point> cList = new ArrayList<Point>();// 2
	static List<Point> bList = new ArrayList<Point>();// 1
	static List<Point> wList = new ArrayList<Point>();// 0
	static boolean[] visited = new boolean[3];
	static String[] raiders = { "Tanker", "Mage", "Healer", "Assassin" };
	static int ans;
	static int min = Integer.MAX_VALUE;

	static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int getDist(Point p1, Point p2) {
		return Math.abs(p1.y - p2.y) + Math.abs(p1.x - p2.x);
	}

	static void solve(int type, int depth, int pre, int sum) {
		if (sum > min) {
			return;
		}
		List<Point> pList;
		if (type == 0) {
			pList = wList;
		} else if (type == 1) {
			pList = bList;
		} else if (type == 2) {
			pList = cList;
		} else {
			pList = jList;
		}
		Point prePoint = pre == -1 ? home : pList.get(pre);

		if (depth == 3) {
			sum += getDist(prePoint, dest);
			if (sum <= min) {
				min = sum;
				ans = type;
			}
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (!visited[i]) {
				visited[i] = true;
				solve(type, depth + 1, i, sum + getDist(prePoint, pList.get(i)));
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			String line = in.readLine();
			for (int j = 0; j < n; j++) {
				switch (line.charAt(j)) {
				case 'H': {
					home = new Point(i, j);
					break;
				}
				case 'J': {
					jList.add(new Point(i, j));
					break;
				}
				case 'C': {
					cList.add(new Point(i, j));
					break;
				}
				case 'B': {
					bList.add(new Point(i, j));
					break;
				}
				case 'W': {
					wList.add(new Point(i, j));
					break;
				}
				case '#': {
					dest = new Point(i, j);
					break;
				}
				}
			}
		}
		solve(0, 0, -1, 0);
		solve(1, 0, -1, 0);
		solve(2, 0, -1, 0);
		solve(3, 0, -1, 0);
		System.out.println(raiders[ans]);
	}
}