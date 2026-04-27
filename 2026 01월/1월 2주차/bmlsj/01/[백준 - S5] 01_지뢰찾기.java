import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int R, C;
    static char[][] map;
    static String[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            String[] split = br.readLine().split(" ");
            R = Integer.parseInt(split[0]);
            C = Integer.parseInt(split[1]);

            if (C == 0 && R == 0)
                break;

            map = new char[R][C];
            visited = new String[R][C];

            for (int i = 0; i < R; i++) {
                split = br.readLine().split("");
                for (int j = 0; j < C; j++) {
                    map[i][j] = split[j].charAt(0);
                    visited[i][j] = "0";
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (visited[i][j].equals("0") && map[i][j] == '.') {
                        find(i, j);
                    }
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == '*')
                        System.out.print("*");
                    else
                        System.out.print(visited[i][j]);
                }
                System.out.println();
            }

        }

    }

    static int[] dx = { -1, 1, 0, 0, 1, 1, -1, -1 };
    static int[] dy = { 0, 0, -1, 1, 1, -1, 1, -1 };

    static void find(int x, int y) {

        Queue<int[]> queue = new ArrayDeque<int[]>();
        int cnt = 0;
        queue.offer(new int[] { x, y });

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            x = curr[0];
            y = curr[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C)
                    continue;
                if (visited[nx][ny].equals("0") && map[nx][ny] == '*') {
                    cnt++;
                }
            }
            visited[x][y] = cnt + "";
        }
    }

}