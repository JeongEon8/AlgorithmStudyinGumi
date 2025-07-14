
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

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] maps = new char[R][C];
        int[][] visited = new int[R][C];
        int[][] fireVisited = new int[R][C];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int answer = 0;

        Point start = new Point();
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(bf.readLine());
            String tmp = st.nextToken();
            for (int j = 0; j < C; j++) {
                maps[i][j] = tmp.charAt(j);
                if (maps[i][j] == 'F') {
                    fireVisited[i][j] = 1;
                    queue.add(new Point(i, j));
                } else if (maps[i][j] == 'J') {
                    visited[i][j] = 1;
                    start = new Point(i, j);
                }
            }
        }

        while (queue.size() > 0) {
            Point cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }

                if (maps[nx][ny] == '.' && fireVisited[nx][ny] == 0) {
                    queue.add(new Point(nx, ny));
                    fireVisited[nx][ny] = fireVisited[cur.x][cur.y] + 1;
                }
            }
        }
        queue.add(start);

        while (queue.size() > 0) {
            Point cur = queue.poll();
            if (cur.x == 0 || cur.y == 0 || cur.x == R - 1 || cur.y == C - 1) {
                answer = visited[cur.x][cur.y];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }

                if (maps[nx][ny] == '.' && (visited[nx][ny] == 0 || visited[nx][ny] > visited[cur.x][cur.y] + 1) && (fireVisited[nx][ny] > visited[cur.x][cur.y] + 1 || fireVisited[nx][ny] == 0)) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = visited[cur.x][cur.y] + 1;
                }
            }
        }

        System.out.println(answer == 0 ? "IMPOSSIBLE" : answer);
    }
}
