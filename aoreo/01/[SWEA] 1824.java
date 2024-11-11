import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(bf.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            String answer = "NO";
            char[][] maps = new char[R][C];
            boolean[][][][] visited = new boolean[R][C][4][16]; // 3차원은 이동방향, 4차원은 메모리값 이동방향이 상하좌우 4개니까 
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(bf.readLine());
                String str = st.nextToken();
                for (int j = 0; j < C; j++) {
                    maps[i][j] = str.charAt(j);
                }
            }
            int cx = 0;
            int cy = 0;
            int cdir = 3; // 상 - 0, 하 - 1, 좌 - 2, 우 - 3
            int memory = 0;
            if (maps[cx][cy] >= '0' && maps[cx][cy] <= '9') {
                memory = Integer.parseInt(Character.toString(maps[cx][cy]));
            }
            Queue<Command> queue = new LinkedList<>();
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            visited[cx][cy][cdir][memory] = true;
            queue.add(new Command(cx, cy, cdir, memory));
            while (queue.size() != 0) {
                Command c = queue.poll();
                visited[c.x][c.y][c.dir][c.memory] = true;
                if (maps[c.x][c.y] == '@') {
                    answer = "YES";
                    break;
                } else if (maps[c.x][c.y] >= '0' && maps[c.x][c.y] <= '9') {
                    int nx = dx[c.dir] + c.x;
                    int ny = dy[c.dir] + c.y;

                    if (nx == -1) {
                        nx = R - 1;
                    } else if (nx == R) {
                        nx = 0;
                    }
                    if (ny == -1) {
                        ny = C - 1;
                    } else if (ny == C) {
                        ny = 0;
                    }

                    if (visited[nx][ny][c.dir][Integer.parseInt(Character.toString(maps[c.x][c.y]))] == false) {
                        visited[nx][ny][c.dir][Integer.parseInt(Character.toString(maps[c.x][c.y]))] = true;
                        queue.add(new Command(nx, ny, c.dir, Integer.parseInt(Character.toString(maps[c.x][c.y]))));
                    }

                } else if (maps[c.x][c.y] == '?') {
                    for (int i = 0; i < 4; i++) {
                        int nx = dx[i] + c.x;
                        int ny = dy[i] + c.y;

                        if (nx == -1) nx = R - 1; 
                        else if (nx == R) nx = 0;
                        if (ny == -1) ny = C - 1; 
                        else if (ny == C) ny = 0;

                        if (visited[nx][ny][i][c.memory] == false) {
                          visited[nx][ny][i][c.memory] = true;
                          queue.add(new Command(nx, ny, i, c.memory));
                      }
                    }

                } else {
                    int nx = c.x;
                    int ny = c.y;
                    int ndir = c.dir;
                    int nmemory = c.memory;
                    switch (maps[c.x][c.y]) {
                        case '<':
                            nx = dx[2] + c.x;
                            ny = dy[2] + c.y;

                            ndir = 2;
                            break;
                        case '>':
                            nx = dx[3] + c.x;
                            ny = dy[3] + c.y;

                            ndir = 3;
                            break;
                        case '^':
                            nx = dx[0] + c.x;
                            ny = dy[0] + c.y;

                            ndir = 0;
                            break;
                        case 'v':
                            nx = dx[1] + c.x;
                            ny = dy[1] + c.y;

                            ndir = 1;
                            break;
                        case '_':
                            if (c.memory == 0) {
                                nx = dx[3] + c.x;
                                ny = dy[3] + c.y;

                                ndir = 3;
                                break;
                            } else {
                                nx = dx[2] + c.x;
                                ny = dy[2] + c.y;

                                ndir = 2;
                                break;
                            }
                        case '|':
                            if (c.memory == 0) {
                                nx = dx[1] + c.x;
                                ny = dy[1] + c.y;

                                ndir = 1;
                                break;
                            } else {
                                nx = dx[0] + c.x;
                                ny = dy[0] + c.y;

                                ndir = 0;
                                break;
                            }
                        case '.':
                            nx = dx[c.dir] + c.x;
                            ny = dy[c.dir] + c.y;
                            break;
                        case '+':
                            nx = dx[c.dir] + c.x;
                            ny = dy[c.dir] + c.y;

                            if (c.memory == 15) {
                                nmemory = 0; 
                            }else {
                                nmemory = c.memory + 1;
                            }
                            break;
                        case '-':
                            nx = dx[c.dir] + c.x;
                            ny = dy[c.dir] + c.y;

                            if (c.memory == 0) {
                                nmemory = 15; 
                            }else {
                                nmemory = c.memory - 1;
                            }
                            break;
                    }

                    if (nx == -1) nx = R - 1; 
                    else if (nx == R) nx = 0;
                    if (ny == -1) ny = C - 1; 
                    else if (ny == C) ny = 0;

                    if (visited[nx][ny][ndir][nmemory] == false) {
                        visited[nx][ny][ndir][nmemory] = true;
                        queue.add(new Command(nx, ny, ndir, nmemory));
                    }
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }

    static class Command {
        int x;
        int y;
        int dir;
        int memory;

        public Command(int x, int y, int dir, int memory) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.memory = memory;
        }
    }
}
