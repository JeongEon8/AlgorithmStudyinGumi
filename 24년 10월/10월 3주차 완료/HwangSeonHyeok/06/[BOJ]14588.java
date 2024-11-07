import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static class Line {
		int start, end;

		public Line(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

	}

	static int[][] friendDist;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		friendDist = new int[n + 1][n + 1];
		Line[] lineArr = new Line[n + 1];
		for (int i = 1; i <= n; i++) {
			String[] split = in.readLine().split(" ");
			int start = Integer.parseInt(split[0]);
			int end = Integer.parseInt(split[1]);
			lineArr[i] = new Line(start, end);
		}
		for (int i = 1; i <= n; i++) {
			Line lineA = lineArr[i];
			for (int j = i + 1; j <= n; j++) {
				Line lineB = lineArr[j];
				if (check(lineA, lineB)) {
					friendDist[i][j] = 1;
					friendDist[j][i] = 1;
				}

			}
		}
		for (int m = 1; m <= n; m++) {
			for (int i = 1; i <= n; i++) {
				if (friendDist[i][m] == 0)
					continue;
				for (int j = 1; j <= n; j++) {
					if (m == j || i == j || friendDist[m][j] == 0)
						continue;
					if (friendDist[i][j] == 0)
						friendDist[i][j] = 100000;
					friendDist[i][j] = Math.min(friendDist[i][j], friendDist[i][m] + friendDist[m][j]);
				}
			}
		}
		int q = Integer.parseInt(in.readLine());
		for (int i = 0; i < q; i++) {
			String[] split = in.readLine().split(" ");
			int start = Integer.parseInt(split[0]);
			int end = Integer.parseInt(split[1]);
			int ans = friendDist[start][end];
			if (ans == 0)
				System.out.println(-1);
			else
				System.out.println(ans);

		}

	}

	static boolean check(Line a, Line b) {

		return (a.start <= b.start && b.start <= a.end) || (a.start <= b.end && b.end <= a.end)
				|| (b.start <= a.start && a.start <= b.end) || (b.start <= a.end && a.end <= b.end);
	}

}