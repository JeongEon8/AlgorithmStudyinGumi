import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589 {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 상하좌우 이동
    static Queue<int[]> landList = new ArrayDeque<>(); // 육지 위치 저장용 큐
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                // 육지의 위치 저장하기
                if (map[i][j] == 'L') landList.add(new int[]{i, j});
            }
        }

        int time = 0;
        // 각 육지에서의 최단 거리 구하기
        while (!landList.isEmpty()) {
            int[] land = landList.poll();
            visited = new boolean[N][M];
            // 각 최단 거리의 최대값 구하기
            time = Math.max(time, bfs(land[0], land[1]));
        }
        System.out.println(time);
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for (int s = 0; s < size; s++) {
                int[] now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + move[i][0];
                    int ny = now[1] + move[i][1];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        continue;
                    }

                    if (!visited[nx][ny] && map[nx][ny] == 'L') {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return time - 1; // 시작 위치는 시간을 세지 않음
    }
}
