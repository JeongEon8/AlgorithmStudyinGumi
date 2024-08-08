import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1949 {

    static int N, K, maxH, maxLen;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visited = new boolean[N][N];
            maxH = 0;
            maxLen = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxH = Math.max(maxH, map[i][j]);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == maxH) {
                        // 최대 높이인 곳에서 탐색 시작
                        visited[i][j] = true;
                        dfs(i, j, 1, false); // 자신부터 세야 하므로 초기값은 1
                        visited[i][j] = false;
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(maxLen).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y, int len, boolean isCrash) {
        maxLen = Math.max(maxLen, len);

        // 네 방향으로 이동
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                continue;
            }

            // 높은 지형에서 낮은 지형으로 이동하는 경우
            if (map[nx][ny] < map[x][y]) {
                visited[nx][ny] = true;
                dfs(nx, ny, len + 1, isCrash);
                visited[nx][ny] = false;
            }
            // 낮은 지형에서 높은 지형으로 이동하는 경우 & 지형을 깎지 않은 경우
            else if (map[nx][ny] >= map[x][y] && !isCrash) {
                int crash = map[nx][ny] - map[x][y] + 1;
                // 현재 지형과 차이가 적을수록 등산로의 길이가 길어짐
                if (crash <= K) { // 깎는 높이가 K를 넘지 않을 때만 깎기
                    map[nx][ny] -= crash;
                    visited[nx][ny] = true;
                    dfs(nx, ny, len + 1, true);
                    visited[nx][ny] = false;
                    map[nx][ny] += crash;
                }
            }
        }
    }
}
