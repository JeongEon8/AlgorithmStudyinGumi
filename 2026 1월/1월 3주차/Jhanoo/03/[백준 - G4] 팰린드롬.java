import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] a;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        a = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }

        for (int i = 1; i < N; i++) {
            dp[i][i + 1] = (a[i] == a[i + 1]);
        }

        for (int len = 3; len <= N; len++) {
            for (int l = 1; l + len - 1 <= N; l++) {
                int r = l + len - 1;
                if (a[l] == a[r] && dp[l + 1][r - 1]) {
                    dp[l][r] = true;
                }
            }
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            sb.append(dp[S][E] ? "1" : "0").append("\n");
        }

        System.out.print(sb);
    }
}
