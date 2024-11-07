import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] ropes = new int[n];
		for (int i = 0; i < n; i++) {
			ropes[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(ropes);
		long ans = 0;
		for (int i = 0; i < n; i++) {
			long total = (long) (n - i) * ropes[i];
			if (ans < total) {
				ans = total;
			}
		}
		System.out.println(ans);

	}
}