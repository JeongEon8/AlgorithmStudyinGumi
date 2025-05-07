import java.util.*;

public class Main {
    static int[] dp = new int[11]; // N은 최대 10

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(getMaxFun(N));
    }

    static int getMaxFun(int n) {
        if (n == 1) return 0;
        if (dp[n] != 0) return dp[n];

        int max = 0;
        for (int i = 1; i < n; i++) {
            int left = i;
            int right = n - i;
            int fun = left * right + getMaxFun(left) + getMaxFun(right);
            max = Math.max(max, fun);
        }
        return dp[n] = max;
    }
}
