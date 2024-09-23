import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] has = new int[1000001];
	static int[] want = new int[1000001];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			has[Integer.parseInt(split[i])]++;
		}
		split = in.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			want[Integer.parseInt(split[i])]++;
		}
		int ans = 0;
		for (int i = 0; i < 1000001; i++) {
			ans += Math.max(want[i] - has[i], 0);
		}
		System.out.println(ans);
	}

}