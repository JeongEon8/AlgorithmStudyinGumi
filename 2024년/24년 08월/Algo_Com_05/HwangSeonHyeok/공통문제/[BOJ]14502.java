import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int n, m;
    static int[][] lab;
    static boolean[][] visited;
    static List<Point> vList;
    static int ans = 0;

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int safeArea;

    static void solve(int depth, int currentY, int currentX) {
        if (depth == 3) {
            Queue<Point> q = new ArrayDeque<>();
            visited = new boolean[n][m];
            int virusArea = 0;
            for (Point virus : vList) {
                q.add(virus);
                visited[virus.y][virus.x] = true;
                virusArea++;
            }
            while (!q.isEmpty()) {
                Point current = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nextX = current.x + dx[i];
                    int nextY = current.y + dy[i];
                    if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m || lab[nextY][nextX] == 1
                            || visited[nextY][nextX])
                        continue;
                    visited[nextY][nextX] = true;
                    q.add(new Point(nextY, nextX));
                    virusArea++;
                }
                if (safeArea - virusArea < ans) {
                    return;
                }
            }
            ans = safeArea - virusArea;
            return;
        }

        for (int i = currentY; i < n; i++) {
            for (int j = (i == currentY) ? currentX : 0; j < m; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    if (j == m - 1) {
                        solve(depth + 1, currentY + 1, 0);
                    } else {
                        solve(depth + 1, currentY, currentX + 1);
                    }
                    lab[i][j] = 0;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        lab = new int[n][m];
        vList = new ArrayList<>();
        safeArea = n * m - 3;
        for (int i = 0; i < n; i++) {
            split = in.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(split[j]);
                if (lab[i][j] == 2) {
                    vList.add(new Point(i, j));
                } else if (lab[i][j] == 1) {
                    safeArea--;
                }
            }
        }
        solve(0, 0, 0);
        System.out.println(ans);

    }

}