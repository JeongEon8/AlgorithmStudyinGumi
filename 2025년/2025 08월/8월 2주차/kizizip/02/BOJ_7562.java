import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7562 {
    static boolean[][] visited;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            visited = new boolean[l][l];

            String[] starts = br.readLine().split(" ");
            int startx = Integer.parseInt(starts[0]);
            int starty = Integer.parseInt(starts[1]);
            String[] finals = br.readLine().split(" ");
            int finalx = Integer.parseInt(finals[0]);
            int finaly = Integer.parseInt(finals[1]);

            int answer = bfs(startx, starty, finalx, finaly);

            System.out.println(answer);
        }


    }

    static int bfs(int nowx, int nowy, int finalx, int finaly) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{nowx, nowy, 0});
        visited[nowx][nowy] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            if (x == finalx && y == finaly) {
                return count;
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < l && ny < l && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, count + 1});
                }
            }
        }
        return -1;
    }
}
