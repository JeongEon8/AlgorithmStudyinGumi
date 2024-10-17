import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486 {

	static int N, M;
	static int[] time, pay, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = N + 2;
		time = new int[M];
		pay = new int[M];
		dp = new int[M];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < M; i++) {
			dp[i] = Math.max(dp[i], dp[i - 1]); // 이전까지의 최대 금액 vs 현재까지의 최대 금액

			// 현재 회의를 선택할 수 있는 경우
			if (i + time[i] < M) {
				dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + pay[i]);
			}
		}
		System.out.println(dp[N + 1]);
	}
}
