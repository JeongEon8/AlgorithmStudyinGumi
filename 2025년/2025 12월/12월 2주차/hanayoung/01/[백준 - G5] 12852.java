import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[] dp;
    static int[] parent;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        dp = new int[N+1];
        parent = new int[N+1];

        Arrays.fill(dp, -1);
        dp[1] = 0;
        recur(N);
        System.out.println(dp[N]);
        int cur = N;
        while (true) {
            sb.append(cur).append(' ');
            if (cur == 1) break;
            cur = parent[cur];
        }
        System.out.println(sb);
    }

    public static int recur(int X) {
        if(X == 1) return dp[1] = 0;

        if(dp[X] != -1) return dp[X];

        int min = recur(X-1);
        int next = X - 1;

        if(X % 3 == 0) {
            int t = recur(X/3);
            if(t < min) {
                min = t;
                next = X/3;
            }
        }

        if(X % 2 == 0) {
            int t = recur(X/2);
            if(t < min) {
                min = t;
                next = X/2;
            }
        }
        dp[X] = min +1;
        parent[X] = next;

        return dp[X];
    }

}
