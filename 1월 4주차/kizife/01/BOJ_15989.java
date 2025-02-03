import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] dp;

        int t = sc.nextInt();
        dp = new int[10001][4];

        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();

            for (int i = 4; i <= n; i++) {
                dp[i][1] = dp[i - 1][1];
                dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
                dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
            }

            System.out.println(dp[n][3] + dp[n][2] + dp[n][1]);
        }
    }
}
