import java.io.*;
import java.util.*;

public class b14520 {

    static int n, m;
    static int[][] map;
    static int[][] testMap;
    static List<int[]> virus;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        testMap = new int[n][m];
        virus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        makeWall(0, 0);
        System.out.println(max);
    }

    static void makeWall(int start, int wallNum) {
        if (wallNum == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    testMap[i][j] = map[i][j];
                }
            }

            for (int[] v : virus) {
                bfs(v[0], v[1]);
            }

            max = Math.max(max, getSafeSize());
            return;
        }

        for (int i = start; i < n * m; i++) {
            int x = i / m;
            int y = i % m;

            if (map[x][y] == 0) {
                map[x][y] = 1;
                makeWall(i + 1, wallNum + 1);
                map[x][y] = 0;
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int cx = pos[0];
            int cy = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && testMap[nx][ny] == 0) {
                    testMap[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    static int getSafeSize() {
        int size = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (testMap[i][j] == 0) {
                    size++;
                }
            }
        }
        return size;
    }
}
