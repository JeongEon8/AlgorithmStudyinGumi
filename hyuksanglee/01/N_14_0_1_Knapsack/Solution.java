import java.io.BufferedReader;
import java.io.InputStreamReader;

class Product {
    int V;
    int C;

    Product(int c, int v) {
        this.C = c;
        this.V = v;
    }
}

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());

        for (int t = 1; t <= T; t++) {
            String[] input = in.readLine().split(" ");

            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            int[][] dp = new int[N + 1][K + 1];

            for (int n = 1; n <= N; n++) {
                input = in.readLine().split(" ");
                int V = Integer.parseInt(input[0]);
                int C = Integer.parseInt(input[1]);

                for (int j = 0; j <= K; j++) {
                    dp[n][j] = dp[n - 1][j];
                    if (j >= V) { 
                        dp[n][j] = Math.max(dp[n][j], dp[n - 1][j - V] + C);
                    }
                }
            }

            int result = 0;
            for (int j = 0; j <= K; j++) {
                result = Math.max(result, dp[N][j]);
            }

            System.out.println("#" + t + " " + result);
        }
    }
}