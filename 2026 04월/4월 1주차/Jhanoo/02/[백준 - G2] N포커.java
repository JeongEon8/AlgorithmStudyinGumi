import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 10007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] comb = new int[53][53]; // comb[n][r] => nCr

        for (int n = 0; n <= 52; n++) {
            comb[n][0] = 1;
            comb[n][n] = 1;
            for (int r = 1; r < n; r++) {
                comb[n][r] = (comb[n - 1][r - 1] + comb[n - 1][r]) % MOD;
            }
        }

        int ans = 0;
        int maxFourCard = N / 4;

        for (int i = 1; i <= maxFourCard; i++) {
            int cnt = (comb[13][i] * comb[52 - 4 * i][N - 4 * i]) % MOD;

            // 포함-배제의 원리 이용
            // ∣A∪B∪C∣ = ∣A∣+∣B∣+∣C∣ − (∣A∩B∣+∣B∩C∣+∣C∩A∣) + ∣A∩B∩C∣
            if (i % 2 == 1)
                ans = (ans + cnt) % MOD; // 홀수 -> 더하기
            else
                ans = (ans - cnt + MOD) % MOD; // 짝수 -> 빼기 (음수 방지용 +MOD)
        }

        System.out.println(ans);
    }

}