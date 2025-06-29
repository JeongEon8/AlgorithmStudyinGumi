import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int[][] map;
    static int N, M, tomato, cnt;
    static boolean check;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        M = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);

        map = new int[N][M];
        tomato = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(split[j]);

                if (map[i][j] == 1) {
                    queue.offer(new int[]{i, j, 0});
                }

                if (map[i][j] == 0) {
                    tomato += 1;
                }
            }
        }

        bfs(queue);

        if (check) System.out.println(cnt);
        else System.out.println(-1);

    }

    private static void bfs(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int cx = temp[0];
            int cy = temp[1];
            int time = temp[2];

            cnt = Math.max(cnt, time);

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != 0) {
                    continue;
                }
                map[nx][ny] = 1;
                tomato -= 1;
                queue.offer(new int[]{nx, ny, time + 1});

            }
        }

        check = tomato == 0;
    }
}
