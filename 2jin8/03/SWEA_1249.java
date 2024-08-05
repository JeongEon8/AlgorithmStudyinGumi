import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SWEA_1249 {

    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }
            sb.append("#").append(t).append(" ").append(bfs()).append("\n");
        }
        System.out.println(sb);
    }

    static long bfs() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0, 0));
        visited[0][0] = true;

        int time = 0;
        int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!pq.isEmpty()) {
            Point now = pq.poll(); // 복구 작업 시간이 작은 것부터 꺼내기
            int x = now.x, y = now.y;
            if (x == N - 1 && y == N - 1) { // 종료 지점에 도달하면 탐색 종료
                time = now.time;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny])
                    continue;

                pq.offer(new Point(nx, ny, now.time + map[nx][ny]));
                visited[nx][ny] = true;
            }
        }
        return time;
    }

    static class Point implements Comparable<Point> {
        int x, y;
        int time;// 복구 작업 시간

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Point o) { // 복구 작업 시간을 기준으로 오름차순 정렬
            return Integer.compare(time, o.time);
        }
    }
}
