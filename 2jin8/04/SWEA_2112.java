import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int D, W, K, minCnt;
    static int[][] film, checkFilm;
    static final int MAX = 13;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new int[D][W];
            checkFilm = new int[D][W];

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    // A는 0, B는 1
                    film[i][j] = Integer.parseInt(st.nextToken());
                    checkFilm[i][j] = film[i][j];
                }
            }
            minCnt = MAX + 1; // 두께는 최대 13
            if (K == 1) minCnt = 0;
            else dfs(0, 0);
            sb.append("#").append(t).append(" ").append(minCnt).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int depth, int cnt) {
        if (cnt >= minCnt) {
            return;
        }
        else if (depth == D) {
            if (checkFilm()) {
                minCnt = Math.min(minCnt, cnt);
            }
            return;
        }

        int[] tmp = film[depth].clone();

        // 약품 투입 X
        dfs(depth + 1, cnt);

        // 약품 투입 O (A)
        Arrays.fill(film[depth], 0);
        dfs(depth + 1, cnt + 1);

        // 약품 투입 O (B)
        Arrays.fill(film[depth], 1);
        dfs(depth + 1, cnt + 1);

        // 되돌리기
        film[depth] = tmp.clone();
    }

    // 성능 검사
    static boolean checkFilm() {
        for (int i = 0; i < W; i++) {
            int cnt = 1, now = film[0][i];
            for (int j = 1; j < D; j++) {
                if (now == film[j][i]) { // 동일한 특성을 가지는 경우
                    cnt++;
                } else { // 다른 특성을 가지는 경우, 리셋
                    cnt = 1;
                    now = film[j][i];
                }

                // 검사에 통과한 경우
                if (cnt >= K) {
                    break;
                }
            }
            if (cnt < K) return false;
        }
        return true;
    }
}
