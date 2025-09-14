import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int[][] chunks;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] maps = new int[N][N];
        chunks = new int[N][N];

        ArrayList<Point> islands = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] == 1) {
                    islands.add(new Point(i, j));
                }
            }
        }

        int[][] visited = new int[N][N];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        checkSameIsland(maps, N, islands);

        int answer = Integer.MAX_VALUE;
        for (Point p : islands) {
            Queue<Point> q = new LinkedList<>();
            q.add(p);
            visited[p.x][p.y] = 1;

            while (q.size() > 0) {
                Point cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }

                    if (maps[nx][ny] == 0 && (visited[nx][ny] == 0 || visited[nx][ny] > visited[cur.x][cur.y] + 1)) {
                        visited[nx][ny] = visited[cur.x][cur.y] + 1;
                        q.add(new Point(nx, ny));
                    }

                    if (maps[nx][ny] == 1 && chunks[nx][ny] != chunks[p.x][p.y]) // 0이고 가까운 곳만 다리를 짓되, 1이 나타나면 도착했으니 값 비교하기
                    {
                        answer = Math.min(answer, visited[cur.x][cur.y] - 1);
                    }
                }
            }

        }

        System.out.println(answer);

    }

    static void checkSameIsland(int[][] maps, int N, ArrayList<Point> islands) {
        boolean[][] visited = new boolean[N][N];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Point> q = new LinkedList<>();
        int count = 1;

        for (Point p : islands) {
            if (visited[p.x][p.y] == false) {
                q.add(p);
                visited[p.x][p.y] = true;
                chunks[p.x][p.y] = count;

                while (q.size() > 0) {
                    Point cur = q.poll();

                    for (int i = 0; i < 4; i++) {
                        int nx = cur.x + dx[i];
                        int ny = cur.y + dy[i];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                            continue;
                        }

                        if (maps[nx][ny] == 1 && visited[nx][ny] == false) {
                            q.add(new Point(nx, ny));
                            visited[nx][ny] = true;
                            chunks[nx][ny] = count;
                        }
                    }
                }
                count++;
            }

        }
    }
}
