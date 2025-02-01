import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static class Typing implements Comparable<Typing> {
		int a, b;
		String alph;

		public Typing(int a, int b, String alph) {
			this.a = a;
			this.b = b;
			this.alph = alph;
		}

		@Override
		public int compareTo(Typing o) {
			if (this.b == o.b) {
				return this.a - o.a;
			}
			return this.b - o.b;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer ans = new StringBuffer();
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[1]);
		Typing[] arr = new Typing[n];
		for (int i = 0; i < n; i++) {
			split = in.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			String str = split[2];
			arr[i] = new Typing(a, b, str);
		}
		Arrays.sort(arr);
		for (Typing t : arr) {
			ans.append(t.alph);
		}
		System.out.println(ans);
	}

}