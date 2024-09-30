import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {

	static int N, M, cnt;
	static int[] arr, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		dp = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i] + dp[i - 1];
		}

		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				int sum = dp[j] - dp[i - 1];
				if (sum == M)
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}
