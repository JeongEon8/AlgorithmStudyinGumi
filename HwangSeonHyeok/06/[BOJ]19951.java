import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		int[] arr = new int[n + 1];
		int[] diffArr = new int[n + 1];
		split = in.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(split[i - 1]);
		}
		for (int i = 0; i < m; i++) {
			split = in.readLine().split(" ");
			int start = Integer.parseInt(split[0]);
			int end = Integer.parseInt(split[1]);
			int diff = Integer.parseInt(split[2]);
			diffArr[start] += diff;
			if (end + 1 <= n)
				diffArr[end + 1] -= diff;
		}
		int diff = 0;
		for (int i = 1; i <= n; i++) {
			diff += diffArr[i];
			sb.append(diff + arr[i] + " ");
		}
		System.out.println(sb);

	}

}