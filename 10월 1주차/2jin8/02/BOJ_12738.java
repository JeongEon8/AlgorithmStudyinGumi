import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12738 {

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N];
		Arrays.fill(dp, INF);
		dp[0] = arr[0];
		for (int i = 1; i < N; i++) {
			int idx = Arrays.binarySearch(dp, arr[i]);
			if (idx < 0) {
				idx = -1 * idx - 1;
			}
			dp[idx] = arr[i];
		}

		int len = 0;
		for (int i = 0; i < N; i++) {
			if (dp[i] == INF)
				break;

			len++;
		}
		System.out.println(len);
	}
}
