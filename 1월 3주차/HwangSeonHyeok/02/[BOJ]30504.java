import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Fury implements Comparable<Fury> {
		int idx, point;

		public Fury(int idx, int point) {
			this.idx = idx;
			this.point = point;
		}

		@Override
		public int compareTo(Fury o) {
			return Integer.compare(this.point, o.point);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Fury[] furies = new Fury[n];
		int[] pockets = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			furies[i] = new Fury(i, Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			pockets[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(furies);
		Arrays.sort(pockets);
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			if (furies[i].point > pockets[i]) {
				System.out.println(-1);
				return;
			}
			ans[furies[i].idx] = pockets[i];
		}
		StringBuilder sb = new StringBuilder();
		for (int pocket : ans) {
			sb.append(pocket).append(' ');
		}
		System.out.println(sb);
	}

}