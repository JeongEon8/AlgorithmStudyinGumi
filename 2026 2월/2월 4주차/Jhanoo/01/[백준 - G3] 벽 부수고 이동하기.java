import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] wall;
    static boolean[][][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        wall = new boolean[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                wall[i][j] = s.charAt(j) == '1';
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0, 1}); // x, y, destroyCnt, dist
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int destroyCnt = cur[2];
            int dist = cur[3];

            if (x == N - 1 && y == M - 1) {
                System.out.println(dist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵 밖으로 나가거나 이미 방문한 경우 스킵
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1)
                    continue;

                // 벽인 경우
                if (wall[nx][ny]) {
                    if (destroyCnt == 0 && !visited[nx][ny][1]) {
                        q.offer(new int[]{nx, ny, 1, dist + 1});
                        visited[nx][ny][1] = true;
                    }
                }
                //  길인 경우
                else {
                    if (!visited[nx][ny][destroyCnt]) {
                        q.offer(new int[]{nx, ny, destroyCnt, dist + 1});
                        visited[nx][ny][destroyCnt] = true;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}