
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = -1;
        }

        System.out.println(game(N) == 1 ? "SK" : "CY");

    }

    public static int game(int stone) {

        if (stone == 0) {
            return 0;
        }

        if (dp[stone] != -1) {
            return dp[stone];
        }

        // 돌을 1 or 3개를 뺀 후, 상대가 질 경우
        if (stone - 1 >= 0 && game(stone - 1) == 0) {
            dp[stone] = 1;
            return 1;
        }

        if (stone - 3 >= 0 && game(stone - 3) == 0) {
            dp[stone] = 1;
            return 1;
        }

        // 그렇지 않을 경우, 현재 SK가 패배
        dp[stone] = 0;

        return 0;
    }
}
