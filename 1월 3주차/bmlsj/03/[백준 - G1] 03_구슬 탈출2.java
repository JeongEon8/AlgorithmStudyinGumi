import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int cnt;

    static class State {
        int rx, ry, bx, by, depth;

        State(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new char[N][M];
        int rx = -1, ry = -1;
        int bx = -1, by = -1;
        for (int i = 0; i < N; i++) {
            split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = split[j].charAt(0);
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        visited = new boolean[N][M][N][M];
        cnt = 0;
        bfs(rx, ry, bx, by);
    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static int[] move(int x, int y, int dir) {
        int cnt = 0;
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (map[nx][ny] == '#')
                break;
            x = nx;
            y = ny;
            cnt++;
            if (map[x][y] == 'O')
                break;
        }

        return new int[] { x, y, cnt };
    }

    static void bfs(int x, int y, int bx, int by) {

        visited[x][y][bx][by] = true;
        Queue<State> queue = new ArrayDeque<State>();
        queue.offer(new State(x, y, bx, by, 0));

        while (!queue.isEmpty()) {

            State curr = queue.poll();

            if (curr.depth >= 10) {
                System.out.println("-1");
                return;
            }

            for (int i = 0; i < 4; i++) {
                int[] r = move(curr.rx, curr.ry, i);
                int[] b = move(curr.bx, curr.by, i);

                // 파란공이 빠질 경우
                if (map[b[0]][b[1]] == 'O') {
                    continue;
                }
                // 빨간 공이 빠질 경우
                if (map[r[0]][r[1]] == 'O') {
                    System.out.println(curr.depth + 1);
                    return;
                }

                if (r[0] == b[0] && r[1] == b[1]) {
                    if (r[2] > b[2]) { // 빨간공이 왼쪽에 잇으므로 | 빨 | 파 | 이렇게 위치
                        r[0] -= dx[i];
                        r[1] -= dy[i];
                    } else {
                        b[0] -= dx[i];
                        b[1] -= dy[i];
                    }
                }

                if (!visited[r[0]][r[1]][b[0]][b[1]]) {
                    visited[r[0]][r[1]][b[0]][b[1]] = true;
                    queue.offer(new State(r[0], r[1], b[0], b[1], curr.depth + 1));
                }

            }

        }
        System.out.println("-1");
    }
}