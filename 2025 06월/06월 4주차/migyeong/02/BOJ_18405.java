import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18405 {
    static int[][] map;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static Queue<int[]> queue;

    static int N, K, S, X, Y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]); // 시험관 크기
        K = Integer.parseInt(split[1]); // 바이러스 종류

        map = new int[N][N];
        queue = new ArrayDeque<>();
        List<int[]> tempList = new ArrayList<>();

        // 처음 시험관의 바이러스 위치
        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
                if (map[i][j] > 0) {
                    // 바이러스 번호, x, y, 시간
                    tempList.add(new int[]{map[i][j], i, j, 0});
                }
            }
        }

        // 바이러스 번호가 작은 것부터 먼저 퍼져야 하므로 정렬
        tempList.sort(Comparator.comparingInt(a -> a[0]));
        queue.addAll(tempList);

        split = br.readLine().split(" ");
        S = Integer.parseInt(split[0]); // S초 뒤에
        X = Integer.parseInt(split[1]); // x 위치
        Y = Integer.parseInt(split[2]); // y 위치

        bfs();

        System.out.println(map[X - 1][Y - 1]);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int virus = temp[0];
            int cx = temp[1];
            int cy = temp[2];
            int time = temp[3];

            if (time == S) return;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if (map[nx][ny] == 0) {
                    map[nx][ny] = virus;
                    queue.offer(new int[]{virus, nx, ny, time + 1});
                }
            }
        }
    }
}
