import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_26169 {

    static int N = 5, r, c;
    static boolean isEating = false;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static int[][] map = new int[N][N];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map[r][c] = -1;
        dfs(r, c, 0, 0);
        System.out.println(isEating ? 1 : 0);
    }

    static void dfs(int x, int y, int move, int apple) {
        // 이미 사과를 먹은 경우
        if (isEating) return;

        // 사과 2개 이상 먹고 이동 횟수 남은 경우
        if (apple >= 2 && move <= 3) {
            isEating = true;
            return;
        }

        // 이미 3번 이상 이동한 경우
        if (move == 3) return;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == -1)
                continue;

            int newApple = map[nx][ny];
            map[nx][ny] = -1;
            dfs(nx, ny, move + 1, apple + newApple);
            map[nx][ny] = newApple;

            if (isEating) return;
        }
    }

    static class Pos {
        int x, y, apple, move;

        public Pos(int x, int y, int apple, int move) {
            this.x = x;
            this.y = y;
            this.apple = apple;
            this.move = move;
        }
    }
}
