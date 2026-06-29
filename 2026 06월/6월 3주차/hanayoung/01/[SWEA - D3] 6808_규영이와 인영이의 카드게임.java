import java.io.*;
import java.util.*;

public class Solution {
    static final int CARDCNT = 9;
    static final int MAXSCORE = 171;
    static final int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    static int[] answer = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            answer[0] = 0;
            answer[1] = 0;

            int[] gyCard = new int[CARDCNT];
            boolean[] card = new boolean[CARDCNT * 2 + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < CARDCNT; i++) {
                gyCard[i] = Integer.parseInt(st.nextToken());
                card[gyCard[i]] = true;
            }

            int[] iyCard = new int[CARDCNT];
            int idx = 0;
            for (int i = 1; i <= CARDCNT * 2; i++) {
                if (!card[i]) {
                    iyCard[idx++] = i;
                }
            }

            boolean[] visited = new boolean[CARDCNT];

            perm(0, 0, iyCard, visited, 0, gyCard);

            sb.append("#").append(tc).append(" ").append(answer[0]).append(" ").append(answer[1]).append("\n");
        }

        System.out.print(sb);
    }

    static void perm(int gy, int iy, int[] iyCard, boolean[] visited, int r, int[] gyCard) {
        if (gy > MAXSCORE / 2) {
            answer[0] += factorial[CARDCNT - r];
            return;
        } else if (iy > MAXSCORE / 2) {
            answer[1] += factorial[CARDCNT - r];
            return;
        }

        if (r == CARDCNT) {
            if (gy > iy) answer[0]++;
            else if (gy < iy) answer[1]++;
            return;
        }

        for (int i = 0; i < CARDCNT; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (gyCard[r] > iyCard[i]) {
                    perm(gy + gyCard[r] + iyCard[i], iy, iyCard, visited, r + 1, gyCard);
                } else {
                    perm(gy, iy + gyCard[r] + iyCard[i], iyCard, visited, r + 1, gyCard);
                }
                visited[i] = false;
            }
        }
    }
}
