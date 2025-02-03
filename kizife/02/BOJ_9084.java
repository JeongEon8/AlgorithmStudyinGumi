import java.util.Scanner;

public class Main {

    static int t, n, m;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            coins = new int[n];

            for (int j = 0; j < n; j++) {
                coins[j] = sc.nextInt();
            }

            m = sc.nextInt();
            dp = new int[m + 1];
            dp[0] = 1; // 목표 금액이 0일 때는 방법 하나뿐

            for (int coin : coins) {
                for (int j = coin; j <= m; j++) {
                    dp[j] += dp[j - coin];
                }
            }

            System.out.println(dp[m]);
        }
    }
}
