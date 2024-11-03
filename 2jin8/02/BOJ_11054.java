import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11054 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 왼쪽 > 오른쪽
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		// 오른쪽 > 왼쪽
		int[] rdp = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			rdp[i] = 1;
			for (int j = N - 1; j > i; j--) {
				if (arr[j] < arr[i]) {
					rdp[i] = Math.max(rdp[i], rdp[j] + 1);
				}
			}
		}

		int maxLen = 0;
		for (int i = 0; i < N; i++) { // 두 dp 배열의 값을 더하기 = 바이토닉 수열의 길이
			dp[i] += rdp[i] - 1; // i번째 수를 중복으로 셌으므로 1을 빼야 함
			maxLen = Math.max(maxLen, dp[i]);
		}
		System.out.println(maxLen);
	}
}
