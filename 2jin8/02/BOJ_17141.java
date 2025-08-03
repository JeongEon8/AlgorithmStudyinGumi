import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17141 {

    // 0: 빈 칸, 1: 벽, 2: 바이러스를 놓을 수 있는 칸
    // 바이러스는 최대 10개 => 조합으로 바이러스 두는 위치 정하기
    // 그 후 바이러스가 퍼지는 최소 시간 구하기
    static final int INF = Integer.MAX_VALUE;
    static int N, M, spreadCount, minTime;
    static int[][] map, dist;
    static int[][] virusPlace;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static ArrayList<int[]> emptyList = new ArrayList<>(); // 바이러스 놓을 수 있는 칸 위치 기록

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        virusPlace = new int[M][2];
        spreadCount = N * N;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) { // 벽의 개수
                    spreadCount--;
                } else if (map[i][j] == 2) { // 바이러스를 놓을 수 있는 칸
                    emptyList.add(new int[]{i, j});
                }
            }
        }

        minTime = INF;
        setVirusPlace(0, 0);
        System.out.println(minTime == INF ? -1 : minTime);
    }

    // 바이러스를 놓을 위치 정하기
    static void setVirusPlace(int depth, int start) {
        // 위치 M개 다 선택한 경우
        if (depth == M) {
            // 모든 빈 칸에 바이러스를 퍼뜨리는 최소 시간 구하기
            minTime = Math.min(minTime, getMinTime());
            return;
        }

        for (int i = start; i < emptyList.size(); i++) {
            int[] now = emptyList.get(i);
            virusPlace[depth][0] = now[0];
            virusPlace[depth][1] = now[1];
            setVirusPlace(depth + 1, i + 1);
        }
    }

    static int getMinTime() {
        Queue<int[]> queue = new ArrayDeque<>();
        dist = new int[N][N];
        for (int[] place : virusPlace) {
            int x = place[0], y = place[1];
            queue.offer(new int[]{x, y});
            dist[x][y] = 1;
        }

        int spread = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1];
            if (++spread == spreadCount) {
                return dist[x][y] - 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                if (dist[nx][ny] != 0 || map[nx][ny] == 1) {
                    continue;
                }

                // 빈 칸이나 바이러스가 퍼질 수 있는 칸으로 이동 가능
                queue.offer(new int[]{nx, ny});
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
        return INF;
    }
}
