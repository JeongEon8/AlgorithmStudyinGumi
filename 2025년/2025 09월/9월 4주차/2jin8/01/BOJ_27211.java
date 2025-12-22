import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_27211 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int area = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    bfs(i, j);
                    area++;
                }
            }
        }
        System.out.println(area);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                // 연결되어 있으므로 범위 벗어나도 좌표 옮겨주기
                if (nx < 0) nx = N - 1;
                if (ny < 0) ny = M - 1;
                if (nx >= N) nx = 0;
                if (ny >= M) ny = 0;

                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
