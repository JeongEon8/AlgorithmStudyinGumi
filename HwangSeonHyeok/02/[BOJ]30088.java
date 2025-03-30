import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		long ans = 0;
		long[] department = new long[n];
		for (int i = 0; i < n; i++) {
			String[] split = in.readLine().split(" ");
			int num = Integer.parseInt(split[0]);
			for (int j = 1; j <= num; j++) {
				department[i] += Long.parseLong(split[j]);
			}
		}
		Arrays.sort(department);
		long prefixSum = 0;
		for (long time : department) {
			prefixSum += time;
			ans += prefixSum;
		}
		System.out.println(ans);
	}

}
