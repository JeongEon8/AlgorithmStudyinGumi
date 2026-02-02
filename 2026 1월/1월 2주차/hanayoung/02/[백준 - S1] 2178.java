import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        Queue<Point> q = new LinkedList<>();
        int[][] visited = new int[N][M];

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            for(int j = 0; j < str.length(); j++) {
                maps[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
            }
        }

        q.add(new Point(0,0));
        visited[0][0] = 1;
        
        while(q.size() > 0) {
            Point cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(maps[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[cur.x][cur.y] + 1;
                    q.add(new Point(nx, ny));
                }
            }
        }

        System.out.println(visited[N-1][M-1]);

    }
}
