import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2096 {

	static int N;
	static int[][] arr, minDP, maxDP;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][3];
		minDP = new int[N + 1][3];
		maxDP = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			minDP[i][0] = Math.min(minDP[i - 1][0], minDP[i - 1][1]) + arr[i][0];
			minDP[i][1] = Math.min(minDP[i - 1][0], Math.min(minDP[i - 1][1], minDP[i - 1][2])) + arr[i][1];
			minDP[i][2] = Math.min(minDP[i - 1][1], minDP[i - 1][2]) + arr[i][2];

			maxDP[i][0] = Math.max(maxDP[i - 1][0], maxDP[i - 1][1]) + arr[i][0];
			maxDP[i][1] = Math.max(maxDP[i - 1][0], Math.max(maxDP[i - 1][1], maxDP[i - 1][2])) + arr[i][1];
			maxDP[i][2] = Math.max(maxDP[i - 1][1], maxDP[i - 1][2]) + arr[i][2];
		}

		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, minDP[N][i]);
			max = Math.max(max, maxDP[N][i]);
		}
		System.out.println(max + " " + min);
	}
}
