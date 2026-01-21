
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        L = Integer.parseInt(split[1]);
        R = Integer.parseInt(split[2]);

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        // 인구차이가 L이상, R이하
        // 연합의 인구수 / 연합을 이룬 칸의 수
        // 인접한 구역을 갈 수 있는 지 확인
        int ans = 0;
        while (true) {

            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<int[]> union = isOpen(i, j);

                        if (union.size() >= 2) {

                            moved = true;
                            int cnt = 0, population = 0;
                            cnt = union.size();
                            for (int[] curr : union) {
                                population += map[curr[0]][curr[1]];
                            }

                            for (int[] curr : union) {
                                map[curr[0]][curr[1]] = population / cnt;
                            }
                        }

                    }
                }
            }

            if (!moved) {
                break;
            }
            ans++;
        }

        System.out.println(ans);

    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static List<int[]> isOpen(int x, int y) {

        // visited[x][y] = true;
        List<int[]> tmp = new ArrayList<int[]>();
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{x, y});
        tmp.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            x = curr[0];
            y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                int diff = Math.abs(map[x][y] - map[nx][ny]);
                if (!visited[nx][ny] && diff >= L && diff <= R) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    tmp.add(new int[]{nx, ny});
                }
            }
        }

        return tmp;
    }

}
