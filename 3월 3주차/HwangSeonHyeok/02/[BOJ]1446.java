import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static class ShortCut implements Comparable<ShortCut> {
		int start, end, dist;

		public ShortCut(int start, int end, int dist) {
			super();
			this.start = start;
			this.end = end;
			this.dist = dist;
		}

		@Override
		public int compareTo(ShortCut o) {
			return this.start - o.start;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int d = Integer.parseInt(split[1]);
		ShortCut[] shortCuts = new ShortCut[n];
		for (int i = 0; i < n; i++) {
			split = in.readLine().split(" ");
			int start = Integer.parseInt(split[0]);
			int end = Integer.parseInt(split[1]);
			int dist = Integer.parseInt(split[2]);
			shortCuts[i] = new ShortCut(start, end, dist);
		}
		Arrays.sort(shortCuts);
		int ans = d;
		int[] highway = new int[10001];
		for (int i = 0; i < 10001; i++) {
			highway[i] = i;
		}
		for (int i = 0; i < n; i++) {
			ShortCut sc = shortCuts[i];
			if (sc.end > d)
				continue;
			highway[sc.end] = Math.min(highway[sc.end], Math.min(highway[sc.start] + sc.dist, sc.end));
			for (int j = i + 1; j < n; j++) {
				ShortCut next = shortCuts[j];
				if (next.start <= sc.end)
					continue;
				highway[next.start] = Math.min(highway[next.start], highway[sc.end] + next.start - sc.end);
			}
			ans = Math.min(highway[sc.end] + d - sc.end, ans);
		}
		System.out.println(ans);

	}

}
