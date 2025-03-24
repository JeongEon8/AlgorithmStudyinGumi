import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static class Domino implements Comparable<Domino> {
		int a, l;

		public Domino(int a, int l) {
			super();
			this.a = a;
			this.l = l;
		}

		@Override
		public int compareTo(Domino o) {
			return this.a - o.a;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Domino[] dominos = new Domino[n];
		for (int i = 0; i < n; i++) {
			String[] split = in.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int l = Integer.parseInt(split[1]);
			dominos[i] = new Domino(a, l);
		}
		Arrays.sort(dominos);
		int ans = 1;
		for (int i = 1; i < n; i++) {
			if (dominos[i].a > dominos[i - 1].a + dominos[i - 1].l) {
				ans++;
			}
		}
		System.out.println(ans);
	}

}
