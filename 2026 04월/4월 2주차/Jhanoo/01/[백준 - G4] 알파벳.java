import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] board;
    static int answer = 0;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int startMask = 1 << (board[0][0] - 'A');

        dfs(0, 0, startMask, 1);

        System.out.println(answer);
    }

    static void dfs(int r, int c, int mask, int depth) {
        answer = Math.max(answer, depth);

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

            int nextBit = 1 << (board[nr][nc] - 'A');

            if ((mask & nextBit) != 0) continue;

            dfs(nr, nc, mask | nextBit, depth + 1);
        }
    }
}