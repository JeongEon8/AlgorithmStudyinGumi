import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int q = Integer.parseInt(split[1]);
		int[] arr = new int[n + 1];
		split = in.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		Arrays.sort(arr);
		for (int i = 1; i <= n; i++) {
			arr[i] += arr[i - 1];
		}
		for (int i = 0; i < q; i++) {
			split = in.readLine().split(" ");
			sb.append(arr[Integer.parseInt(split[1])] - arr[Integer.parseInt(split[0]) - 1] + "\n");
		}
		System.out.println(sb);
	}

}