import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] maps = new int[N][N];
        ArrayList<Point> home = new ArrayList<>();
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            String str = new StringTokenizer(bf.readLine()).nextToken();
            for(int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
                if(maps[i][j] == 1) home.add(new Point(i,j));
            }
        }

        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for(Point p : home) {
            if(visited[p.x][p.y] == false) {
                int cnt = 1;
                q.add(p);
                visited[p.x][p.y] = true;
                while(q.size() > 0) {
                    Point cur = q.poll();

                    for(int i = 0; i < 4; i++) {
                        int nx = cur.x + dx[i];
                        int ny = cur.y + dy[i];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                        if(maps[nx][ny] == 1 && visited[nx][ny] == false) {
                            q.add(new Point(nx, ny));
                            visited[nx][ny] = true;
                            cnt++;
                        }
                    }
                }
                pQueue.add(cnt);
            }
         }

        StringBuilder sb = new StringBuilder();
        sb.append(pQueue.size()).append("\n");
        while(pQueue.size() > 0) {
            sb.append(pQueue.poll()).append("\n");
        }

        System.out.println(sb);
    }
}

