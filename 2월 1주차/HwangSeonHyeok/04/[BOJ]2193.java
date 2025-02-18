import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        dp = new long[n][2];
        dp[0][1] = 1;
        for(int i = 1; i<n; i++){
            dp[i][1] = dp[i-1][0];
            dp[i][0] = dp[i-1][0]+dp[i-1][1];
        }
        long ans = dp[n-1][0]+dp[n-1][1];
        System.out.println(ans);

    }
}