import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static class Minsik {
        int x, y;
        int key = 0;
        int step = 0;

        public Minsik(int x, int y, int key, int step) {
            super();
            this.x = x;
            this.y = y;
            this.key = key;
            this.step = step;
        }
    }

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        int ans = 0;
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        char[][] maze = new char[n][m];
        boolean[][][] visited;
        visited = new boolean[n][m][64];
        Queue<Minsik> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String row = in.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = row.charAt(j);
                if (maze[i][j] == '0') {
                    q.add(new Minsik(j, i, 0, 0));
                    visited[i][j][0] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            Minsik current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && maze[nextY][nextX] != '#') {
                    if (maze[nextY][nextX] >= 'a' && maze[nextY][nextX] <= 'f') {
                        int key = current.key | (1 << (maze[nextY][nextX] - 'a'));
                        if (!visited[nextY][nextX][key]) {
                            q.add(new Minsik(nextX, nextY, key, current.step + 1));
                            visited[nextY][nextX][key] = true;
                        }
                    } else if (maze[nextY][nextX] >= 'A' && maze[nextY][nextX] <= 'F') {
                        int hasKey = current.key & (1 << (maze[nextY][nextX] - 'A'));
                        if (!visited[nextY][nextX][current.key] && hasKey != 0) {
                            q.add(new Minsik(nextX, nextY, current.key, current.step + 1));
                            visited[nextY][nextX][current.key] = true;
                        }

                    } else if (maze[nextY][nextX] == '1') {
                        ans = current.step + 1;
                        q.clear();
                        break;
                    } else {
                        if (!visited[nextY][nextX][current.key]) {
                            q.add(new Minsik(nextX, nextY, current.key, current.step + 1));
                            visited[nextY][nextX][current.key] = true;
                        }

                    }

                }
            }
        }
        if (ans == 0) {
            System.out.print(-1);
        } else {
            System.out.print(ans);
        }

    }

}