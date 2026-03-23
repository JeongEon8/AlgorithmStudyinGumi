import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1711 {
	public static class Point {
		long x;
		long y;

		Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Point[] points = new Point[N];
		int count = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			points[i] = new Point(x, y);
		}

		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					long d1 = getDistSq(points[i], points[j]);
					long d2 = getDistSq(points[i], points[k]);
					long d3 = getDistSq(points[j], points[k]);

					if (d1 + d2 == d3 || d1 + d3 == d2 || d2 + d3 == d1) {
						count++;
					}
				}
			}
		}

		System.out.println(count);
	}

	public static long getDistSq(Point p1, Point p2) {
		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}
}