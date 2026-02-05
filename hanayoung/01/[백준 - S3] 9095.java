import java.io.*;

class Main {
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(bf.readLine());
            System.out.println(recur(n));
        }
    }

    static int recur(int n) {
        if(n <= 0) return 0;
        if(dp[n] != 0) return dp[n];
        return recur(n-1) + recur(n-2) + recur(n-3);
    }
}
