import java.util.Scanner;

public class BOJ_15489 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        int w = sc.nextInt();

        int[][] dp = new int[r+w + 1][r+w + 1];
        for (int i = 1; i <= r+w; i++) {
            dp[i][1] = dp[i][i] = 1; //양끝 1 삽입

            for (int j = 2; j < i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }

        }

        int sum = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j <= i; j++) {
                sum += dp[r + i][c + j];
            }
        }

        System.out.println(sum);
    }
}
