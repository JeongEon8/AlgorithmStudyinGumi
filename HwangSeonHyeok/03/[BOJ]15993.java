import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int mod = 1000000009;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(in.readLine());
		int[][] dp = new int[100001][2];//0은 짝 1은 홀
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][0] = 1;
		dp[3][1] = 2;
		dp[3][0] = 2;
		
		for(int i = 4; i<=100000;i++) {
			dp[i][0] = ((dp[i-1][1]+dp[i-2][1])%mod+dp[i-3][1])%mod;
			dp[i][1] = ((dp[i-1][0]+dp[i-2][0])%mod+dp[i-3][0])%mod;
		}
		for(int tc = 1; tc<=t; tc++) {
			int n = Integer.parseInt(in.readLine());
			
			sb.append(dp[n][1]+" "+dp[n][0]+'\n');
		}
		System.out.print(sb.toString());
	}
}