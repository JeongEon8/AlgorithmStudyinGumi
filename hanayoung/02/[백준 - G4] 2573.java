import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maps = new int[N][M];

        ArrayList<Point> icebergs = new ArrayList<>(); // 여기는 남아있는 빙산들 담을 용도
        int answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] > 0) {
                    icebergs.add(new Point(i, j));
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (icebergs.size() > 0) {
            // 현재 남아있는 빙하를 q에 담고
            // 하나의 while은 1년 단위인걸로
            // while이 끝나면 maps들 줄이고 icebergs도 리스트에서 제거하기
            boolean[][] visited = new boolean[N][M];
            Queue<Point> q = new LinkedList<>();
            int chunk = 0;
            for (Point p : icebergs) {
                if (visited[p.x][p.y] == false) {
                    chunk++;
                    q.add(p);
                    visited[p.x][p.y] = true;
                    while (q.size() > 0) {
                        Point cur = q.poll();
                        for (int i = 0; i < 4; i++) {
                            int nx = cur.x + dx[i];
                            int ny = cur.y + dy[i];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                                continue;
                            }

                            if(visited[nx][ny] == false && maps[nx][ny] > 0) {
                                q.add(new Point(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            if(chunk > 1) break;

            int[][] minus = new int[N][M];
            ArrayList<Point> gone = new ArrayList<>();
            for (Point p : icebergs) {
                int count = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }

                    if (maps[nx][ny] == 0) {
                        count++;
                    }
                }
                if(maps[p.x][p.y] - count <= 0) {
                    gone.add(p);
                    minus[p.x][p.y] = 0;
                } else {
                    minus[p.x][p.y] = maps[p.x][p.y] - count;
                }
            }

            for (int i = 0; i < N; i++) {
                maps[i] = minus[i].clone();
            }
            icebergs.removeAll(gone);
            answer++;
        }

        if(icebergs.size() == 0) answer = 0;
        System.out.println(answer);
    }
}
