
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, T;
    static int[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        T = Integer.parseInt(split[2]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        visited = new int[N][M][2];
        int result = rescue(0, 0);
        if (result == -1 || result > T) {
            System.out.println("Fail");
        } else {
            System.out.println(result);
        }
    }

    static int[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int rescue(int x, int y) {

        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{x, y, 0});
        visited[x][y][0] = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            x = curr[0];
            y = curr[1];
            int hasGram = curr[2];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (visited[x][y][hasGram] > T) {
                    continue;
                }

                if (nx == N - 1 && ny == M - 1) {
                    visited[nx][ny][hasGram] = visited[x][y][hasGram] + 1;
                    return visited[nx][ny][hasGram] - 1;
                }

                int nextGram = hasGram;
                if (map[nx][ny] == 2) { // 검 획득
                    nextGram = 1;
                }

                if (visited[nx][ny][nextGram] == 0) {
                    // 벽인데, 검이 없을 경우
                    if (map[nx][ny] == 1 && nextGram == 0) {
                        continue;
                    }

                    visited[nx][ny][nextGram] = visited[x][y][hasGram] + 1;
                    queue.offer(new int[]{nx, ny, nextGram});

                }
            }

        }

        return -1;
    }

}
