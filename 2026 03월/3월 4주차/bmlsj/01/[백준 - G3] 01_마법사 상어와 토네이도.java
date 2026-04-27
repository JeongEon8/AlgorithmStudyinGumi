
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair {

    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Spread {

    int dx, dy, percent;

    Spread(int dx, int dy, int percent) {
        this.dx = dx;
        this.dy = dy;
        this.percent = percent;
    }
}

/*
 * ratio도 방향에 따라 회전을 해야함.
 * 
 */
public class Main {

    static int[][] map;
    static int n;
    static int answer = 0;

    static Spread[] ratio = {new Spread(-2, 0, 2), new Spread(-1, -1, 10), new Spread(-1, 0, 7), new Spread(-1, 1, 1),
        new Spread(0, -2, 5), new Spread(1, -1, 10), new Spread(1, 0, 7), new Spread(1, 1, 1),
        new Spread(2, 0, 2)};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        int sx = n / 2, sy = n / 2;

        move(sx, sy);
        System.out.println(answer);
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void move(int x, int y) {

        boolean[][] visited = new boolean[n][n];
        visited[x][y] = true;

        int dir = 0;
        int len = 1;
        while (true) {

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < len; j++) {
                    x += dx[dir];
                    y += dy[dir];

                    // 토네이도 진행
                    storm(x, y, dir);

                    if (x == 0 && y == 0) {
                        return;
                    }

                }
                dir = (dir + 1) % 4;
            }

            len++;

        }

    }

    static void storm(int x, int y, int dir) {

        // 비율 별로 모래가 흩날린다
        int sand = map[x][y];
        int totalMoved = 0;

        for (Spread spread : ratio) {

            int nx = 0, ny = 0;

            switch (dir) {
                case 0: {
                    nx = x + spread.dx;
                    ny = y + spread.dy;
                    break;
                }
                case 1: {
                    nx = x - spread.dy;
                    ny = y + spread.dx;
                    break;
                }

                case 2: {
                    nx = x - spread.dx;
                    ny = y - spread.dy;
                    break;
                }
                case 3: {
                    nx = x + spread.dy;
                    ny = y - spread.dx;
                    break;
                }
            }

            int moved = (int) (sand * spread.percent / 100);
            totalMoved += moved;

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                answer += moved;
            } else {
                map[nx][ny] += moved;
            }

        }

        int ax = x + dx[dir];
        int ay = y + dy[dir];
        int alpha = sand - totalMoved;

        if (ax < 0 || ay < 0 || ax >= n || ay >= n) {
            answer += alpha;
        } else {
            map[ax][ay] += alpha;
        }

    }
}
