import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18404 {

    static int N, M, sx, sy;
    static Horse[] horses;
    static int[][] dist;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken()); // 나이트의 x 좌표
        sy = Integer.parseInt(st.nextToken()); //  나이트의 y 좌표
        dist = new int[N + 1][N + 1];
        horses = new Horse[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            horses[i] = new Horse(x, y);
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (Horse horse : horses) {
            sb.append(dist[horse.x][horse.y] - 1).append(" ");
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Horse> queue = new ArrayDeque<>();
        queue.offer(new Horse(sx, sy));
        dist[sx][sy] = 1;
        
        while (!queue.isEmpty()) {
            Horse now = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx <= 0 || ny <= 0 || nx > N || ny > N || dist[nx][ny] != 0)
                    continue;

                queue.offer(new Horse(nx, ny));
                dist[nx][ny] = dist[now.x][now.y] + 1;
            }
        }
    }

    static class Horse {
        int x, y;

        public Horse(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
