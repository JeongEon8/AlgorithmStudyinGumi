import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1189 {

    static int R, C, K, sx, sy, ex, ey, ans;
    static boolean[][] map, visited;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j) == '.';
            }
        }

        // 시작점: 왼쪽 아래
        sx = R - 1; sy = 0;
        // 도착점: 오른쪽 위
        ex = 0; ey = C - 1;
        visited[sx][sy] = true;
        dfs(1, sx, sy);
        System.out.println(ans);
    }

    static void dfs(int dist, int x, int y) {
        if (dist == K) {
            if (x == ex && y == ey) ans++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C)
                continue;

            // 이미 방문했거나 방문할 수 없는 곳인 경우
            if (visited[nx][ny] || !map[nx][ny])
                continue;

            visited[nx][ny] = true;
            dfs(dist + 1, nx, ny);
            visited[nx][ny] = false;
        }
    }
}
