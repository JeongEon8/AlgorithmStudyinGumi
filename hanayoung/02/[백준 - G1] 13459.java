
import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int answer = 0;

        char[][] maps = new char[N][M];

        boolean[][][][] visited = new boolean[N][M][N][M];

        Queue<Bead> q = new LinkedList<>();
        Point blue = new Point();
        Point red = new Point();

        for (int i = 0; i < N; i++) {
            String str = (new StringTokenizer(bf.readLine())).nextToken();
            for (int j = 0; j < M; j++) {
                maps[i][j] = str.charAt(j);
                switch (maps[i][j]) {
                    case 'B':
                        blue = new Point(i, j);
                        break;
                    case 'R':
                        red = new Point(i, j);
                        break;
                }
            }
        }

        q.add(new Bead(blue, red, 0));
        visited[blue.x][blue.y][red.x][red.y] = true;

        while (q.size() > 0) {
            Bead b = q.poll();
            if (b.depth >= 10) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int redCnt = 0, blueCnt = 0;
                int redNx = b.red.x;
                int redNy = b.red.y;
                int blueNx = b.blue.x;
                int blueNy = b.blue.y;

                while (true) {
                    if (maps[redNx][redNy] == 'O') {
                        break;
                    } else if (maps[redNx][redNy] == '#') {
                        redNx -= dx[i];
                        redNy -= dy[i];
                        break;
                    } else {
                        redCnt++;
                        redNx += dx[i];
                        redNy += dy[i];
                    }
                }
                while (true) {
                    if (maps[blueNx][blueNy] == 'O') {
                        break;
                    } else if (maps[blueNx][blueNy] == '#') {
                        blueNx -= dx[i];
                        blueNy -= dy[i];
                        break;
                    } else {
                        blueCnt++;
                        blueNx += dx[i];
                        blueNy += dy[i];
                    }
                }

                if (maps[blueNx][blueNy] == 'O') {
                    answer = 0;
                } else if (maps[redNx][redNy] == 'O') {
                    answer = 1;
                    q.clear();
                    break;
                } else {
                    if (blueNx == redNx && blueNy == redNy) {
                        if (blueCnt > redCnt) {
                            blueNx -= dx[i];
                            blueNy -= dy[i];
                        } else {
                            redNx -= dx[i];
                            redNy -= dy[i];
                        }
                    }
                    if (visited[blueNx][blueNy][redNx][redNy] == false) {
                        visited[blueNx][blueNy][redNx][redNy] = true;
                        q.add(new Bead(new Point(blueNx, blueNy), new Point(redNx, redNy), b.depth + 1));
                    }
                }

            }
        }
        System.out.println(answer);

    }

    static class Bead {

        Point blue;
        Point red;
        int depth;

        public Bead(Point blue, Point red, int depth) {
            this.blue = blue;
            this.red = red;
            this.depth = depth;
        }
    }

}
