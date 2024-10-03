import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static int[][] map;
    static boolean[][] visited;
    static boolean ans = false;
    static int m, n;

    static void dfs(int curY, int curX) {

        visited[curY][curX] = true;

        if (curY == m - 1) {
            ans = true;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextY = curY + dy[i];
            int nextX = curX + dx[i];
            if (nextY >= 0 && nextX >= 0 && nextY < m && nextX < n && !visited[nextY][nextX]
                    && map[nextY][nextX] == 0) {

                dfs(nextY, nextX);
                if (ans)
                    return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        m = Integer.parseInt(split[0]);
        n = Integer.parseInt(split[1]);
        map = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            String line = in.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            if (map[0][i] == 0 && !visited[0][i]) {
                dfs(0, i);
            }
            if (ans) {
                break;
            }
        }
        if (ans) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

}