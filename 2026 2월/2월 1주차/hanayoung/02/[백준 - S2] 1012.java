import java.awt.Point;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());
        Queue<Point> q = new LinkedList<>();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int answer = 0;

        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] maps = new int[N][M];
            boolean[][] visited = new boolean[N][M];
            List<Point> list = new ArrayList<>();

            q.clear();
            answer = 0;

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(bf.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                maps[Y][X] = 1;
                list.add(new Point(Y, X));
            }

            for(Point p: list) {
                if(visited[p.x][p.y] == false) {
                    q.add(p);
                    visited[p.x][p.y] = true;
                    answer++;
                    while(q.size() > 0) {
                        Point cur = q.poll();
                        for(int i = 0; i < 4; i++) {
                            int nx = cur.x + dx[i];
                            int ny = cur.y + dy[i];

                            if(nx < 0 || nx >= N|| ny < 0 || ny >= M) continue;

                            if(visited[nx][ny] == false && maps[nx][ny] == 1) {
                                q.add(new Point(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
