import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17484 {

    static int N, M, answer;
    static int[][] cost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cost = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) { // 시작점 정하기
            move(0, i, 2, 0);
        }
        System.out.println(answer);
    }

    static void move(int depth, int y, int dir, int total) {
        if (depth == N) {
            answer = Math.min(answer, total);
            return;
        }

        // 이동가능한 모든 방향으로 이동
        for (int d = -1; d <= 1; d++) {
            // 이전이랑 같은 방향으로 이동 X
            if (d == dir) continue;

            int ny = y + d;
            // 범위 벗어나면 X
            if (ny < 0 || ny >= M) continue;

            move(depth + 1, ny, d, total + cost[depth][y]);
        }
    }
}
