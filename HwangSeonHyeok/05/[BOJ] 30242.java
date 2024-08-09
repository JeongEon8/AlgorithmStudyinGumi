import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int board[];
    static int N, ans = 0;
    static boolean isFinished = false;

    static void solve(int deep) {
        if (isFinished)
            return;

        if (deep > N) {
            isFinished = true;
            for (int i = 1; i <= N; i++) {
                System.out.print(board[i] + " ");
            }
            return;
        }
        if (board[deep] == 0) {
            for (int i = 1; i <= N; i++) {
                boolean isPossible = true;
                for (int j = 1; j <= N; j++) {
                    if (j == deep || board[j] == 0)
                        continue;
                    if (board[j] == i) {
                        isPossible = false;
                        break;
                    }
                    if (Math.abs(board[j] - i) == Math.abs(deep - j)) {
                        isPossible = false;
                        break;
                    }
                }
                if (isPossible) {
                    board[deep] = i;
                    solve(deep + 1);
                    board[deep] = 0;
                } else {
                    board[deep] = 0;
                }
                if (isFinished)
                    return;
            }
        } else {
            solve(deep + 1);
            if (isFinished)
                return;

        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        board = new int[N + 1];
        String[] split = in.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            board[i] = Integer.parseInt(split[i - 1]);
        }

        solve(1);
        if (!isFinished) {
            System.out.println(-1);
        }

    }

}