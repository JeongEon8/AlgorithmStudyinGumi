import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[10001];
        for (int i = 0; i <= 10000; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i <= 10000; i++) {
            dp[i] = dp[i - 2] + dp[i];
        }
        for (int i = 3; i <= 10000; i++) {
            dp[i] = dp[i - 3] + dp[i];
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            System.out.println(dp[Integer.parseInt(st.nextToken())]);
        }
    }
}
