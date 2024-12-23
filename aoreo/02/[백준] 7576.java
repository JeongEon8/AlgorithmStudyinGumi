import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][] tomatoes = new int[h][w];
        Queue<Point> queue = new LinkedList<>();
        int[][] visited = new int[h][w];
        boolean allRiped = true;
        int answer = 1;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < w; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if(tomatoes[i][j] == 1) {
                    queue.add(new Point(i,j));
                    visited[i][j] = 1;
                }else allRiped = false;
            }
        }

        if(allRiped) {
            System.out.println(0);
        }else{
            while(queue.size() != 0) {
                Point cur = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;

                    if(tomatoes[nx][ny] != -1 && (visited[nx][ny] > visited[cur.x][cur.y]+1 || visited[nx][ny] == 0)) {
                        // 방문한 적 없거나 더 짧은 일 수가 가능함
                        visited[nx][ny] = visited[cur.x][cur.y] + 1;
                        answer = Math.max(visited[nx][ny], answer);
                        queue.add(new Point(nx,ny));
                    }
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(visited[i][j] == 0 && tomatoes[i][j] == 0) {
                        answer = -1;
                        break;
                    }
                }
            }
            if(answer == -1) System.out.println(answer);
            else System.out.println(answer-1);
        }
    }
}
