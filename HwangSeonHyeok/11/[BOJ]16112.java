import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);
		long[] arcanes = new long[n];
		split = in.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arcanes[i] = Long.parseLong(split[i]);
		}
		Arrays.sort(arcanes);
		long ans = 0;
		for (int i = 0; i < n; i++) {
			ans += arcanes[i] * Math.min(i, k);
		}
		System.out.println(ans);

	}

}