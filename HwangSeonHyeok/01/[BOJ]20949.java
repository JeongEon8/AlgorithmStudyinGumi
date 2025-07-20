import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class PPI implements Comparable<PPI> {
		int ppi, num;

		public PPI(int ppi, int num) {
			super();
			this.ppi = ppi;
			this.num = num;
		}

		@Override
		public int compareTo(PPI o) {
			if (this.ppi == o.ppi) {
				return this.num - o.num;
			}
			return o.ppi - this.ppi;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(in.readLine());
		PPI[] arr = new PPI[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			arr[i] = new PPI(w * w + h * h, i + 1);
		}
		Arrays.sort(arr);
		for (PPI p : arr) {
			sb.append(p.num).append("\n");
		}
		System.out.println(sb);
	}
}