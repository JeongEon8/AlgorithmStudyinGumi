import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx = {0, -1, 0, 1};
    static final int[] dy = {-1, 0, 1, 0};
    static int N;
    static int[][] map;

    static class Prey {
        int x;
        int y;
        int dist;

        public Prey(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int sx = -1;
        int sy = -1;
        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 9) {
                    sy = y;
                    sx = x;
                    map[y][x] = 0;
                }
            }
        }

        int size = 2;
        int eat = 0;
        int time = 0;

        while (true) {
            Prey prey = findNextPrey(sx, sy, size);
            if (prey == null) break;

            time += prey.dist;
            sx = prey.x;
            sy = prey.y;

            map[sy][sx] = 0;
            eat++;
            if (eat == size) {
                eat = 0;
                size++;
            }
        }

        System.out.println(time);
    }

    static Prey findNextPrey(int sx, int sy, int size) {
        boolean[][] visited = new boolean[N][N];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy, 0});
        visited[sy][sx] = true;

        int bestDist = Integer.MAX_VALUE;
        int bestX = -1;
        int bestY = -1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (dist > bestDist) break;

            int cell = map[y][x];
            if (cell > 0 && cell < size) {
                if (dist < bestDist || (y < bestY || (y == bestY && x < bestX))) {
                    bestDist = dist;
                    bestX = x;
                    bestY = y;
                }
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[ny][nx] || map[ny][nx] > size) continue;

                visited[ny][nx] = true;
                q.offer(new int[]{nx, ny, dist + 1});
            }
        }

        if (bestDist == Integer.MAX_VALUE) return null;
        return new Prey(bestX, bestY, bestDist);
    }
}