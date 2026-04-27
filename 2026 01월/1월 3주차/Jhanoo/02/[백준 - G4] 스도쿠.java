import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] board = new int[9][9];
    static int[] rowMask = new int[9];
    static int[] colMask = new int[9];
    static int[] boxMask = new int[9];

    static int[] blankRow = new int[81];
    static int[] blankCol = new int[81];
    static int blankCnt = 0;

    static boolean solved = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int r = 0; r < 9; r++) {
            String line = br.readLine();
            for (int c = 0; c < 9; c++) {
                int v = line.charAt(c) - '0';
                board[r][c] = v;

                if (v == 0) {
                    blankRow[blankCnt] = r;
                    blankCol[blankCnt] = c;
                    blankCnt++;
                } else {
                    int bit = 1 << (v - 1); // 1 ~ 9를 0 ~ 8 로 바꾸고 비트연산
                    rowMask[r] |= bit;
                    colMask[c] |= bit;
                    boxMask[box(r, c)] |= bit;
                }
            }
        }

        dfs(0);

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                sb.append(board[r][c]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static int box(int r, int c) {
        return (r / 3) * 3 + (c / 3);
    }

    static void dfs(int idx) {
        if (solved) return;
        if (idx == blankCnt) {
            solved = true;
            return;
        }

        int r = blankRow[idx];
        int c = blankCol[idx];
        int b = box(r, c);

        int used = rowMask[r] | colMask[c] | boxMask[b]; // 1~9 중 이미 쓰인 숫자들
        int cand = (~used) & 0b111111111; // 빈 칸에 넣을 수 있는 숫자들

        while (cand != 0) {
            int bit = cand & -cand; // 가장 오른쪽의 bit (빈 칸에 넣을 수 있는 숫자들 중 가장 작은 숫자)
            cand -= bit;

            int num = Integer.numberOfTrailingZeros(bit) + 1; // ex) 0b100 = 3, num은 0의 개수 + 1

            board[r][c] = num;
            rowMask[r] ^= bit;
            colMask[c] ^= bit;
            boxMask[b] ^= bit;

            dfs(idx + 1);

            if (solved) return;

            // 원상복구
            rowMask[r] ^= bit;
            colMask[c] ^= bit;
            boxMask[b] ^= bit;
            board[r][c] = 0;
        }
    }
}
