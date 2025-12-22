import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {

    static int[] dp;
    static HashSet<Integer> coins;
    static final int INF = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[k + 1];

        coins = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            coins.add(Integer.valueOf(st.nextToken()));
        }

        recur(k);

        System.out.println(dp[k] == INF ? -1 : dp[k]);
    }

    static int recur(int val) {
        if (val <= 0) {
            return 0;
        }
        if (dp[val] != 0) {
            return dp[val];
        }

        int min = INF;
        for (int coin : coins) {
            if (val >= coin) {
                min = Math.min(min, recur(val - coin) + 1);
            }
        }

        return dp[val] = min;

    }
}
