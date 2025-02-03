import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static Integer[] dp;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new Integer[N + 1];
		arr = new int[N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 0;
		dp[1] = arr[1];
		
		// N이 1일 경우와 2인 경우
		if(N > 1) {
			dp[2] = arr[1] + arr[2];
		}
		
		System.out.println(recur(N));
	}
	
	static int recur(int N) {
		
		if(dp[N] == null) {
			dp[N] = Math.max(Math.max(recur(N - 2), recur(N - 3) + arr[N - 1]) + arr[N], recur(N - 1));
		}
		
		return dp[N];
	}
}