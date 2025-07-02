import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int max = Integer.MIN_VALUE;
    static int N, M;
    static int[][] map;
    static boolean[][] visit;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                solve(i, j, map[i][j], 1);
                visit[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void solve(int row, int col, int sum, int count) {

        // 테트로미노 완성 시 수들의 합 계산
        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int cx = row + dx[i];
            int cy = col + dy[i];

            // 범위 벗어나면 예외 처리
            if (cx < 0 || cx >= N || cy < 0 || cy >= M) {
                continue;
            }

            // 아직 방문하지 않은 곳이라면
            if (!visit[cx][cy]) {

                // 보라색(ㅗ) 테트로미노 만들기 위해 2번째 칸에서 탐색 한번 더 진행
                if (count == 2) {
                    visit[cx][cy] = true;
                    solve(row, col, sum + map[cx][cy], count + 1);
                    visit[cx][cy] = false;
                }

                visit[cx][cy] = true;
                solve(cx, cy, sum + map[cx][cy], count + 1);
                visit[cx][cy] = false;
            }
        }
    }
}