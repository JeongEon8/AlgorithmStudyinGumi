import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[] a = new String[N];

        for (int i = 0; i < N; i++) {
            a[i] = br.readLine();
        }

        sb.append(watch(true, a, N)).append(" ").append(watch(false, a, N));

        System.out.println(sb);
    }

    public static int watch(boolean watchGreen, String[] a, int N) {
        int[][] visited = new int[N][N];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char color = 0;
                if (visited[i][j] == 0) {
                    q.offer(new int[]{j, i});
                    color = a[i].charAt(j);

                    if (!watchGreen && color == 'G') color = 'R';

                    visited[i][j] = ++cnt;
                }

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];

                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];

                        if (0 <= nx && nx < N && 0 <= ny && ny < N && visited[ny][nx] == 0) {
                            char tmpColor = a[ny].charAt(nx);

                            if (!watchGreen && tmpColor == 'G') tmpColor = 'R';

                            if (tmpColor == color) {
                                q.offer(new int[]{nx, ny});
                                visited[ny][nx] = cnt;
                            }
                        }
                    }
                }
            }
        }

        return cnt;
    }

}