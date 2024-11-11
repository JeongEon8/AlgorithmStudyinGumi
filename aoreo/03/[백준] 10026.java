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

        int N = Integer.parseInt(st.nextToken());

        char[][] maps = new char[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            for (int j = 0; j < N; j++) {
                maps[i][j] = str.charAt(j);
            }
        }

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        int area1 = 0; // 적록색약이 아닌 사람
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visited[i][j] == false){
                    area1 += 1;
                    visited[i][j] = true;
                    queue.add(new Point(i,j));
                    while(queue.size() != 0){
                        Point p = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = p.x + dx[k];
                            int ny = p.y + dy[k];

                            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                            if(visited[nx][ny] == false && maps[p.x][p.y] == maps[nx][ny]){
                                queue.add(new Point(nx,ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }
        queue.clear();

        visited = new boolean[N][N];
        int area2 = 0; // 적록색약인 사람
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visited[i][j] == false){
                    area2 += 1;
                    visited[i][j] = true;
                    queue.add(new Point(i,j));
                    while(queue.size() != 0){
                        Point p = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = p.x + dx[k];
                            int ny = p.y + dy[k];

                            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                            if(visited[nx][ny] == false){
                                if(maps[p.x][p.y] == 'B' && maps[p.x][p.y] == maps[nx][ny]){
                                    queue.add(new Point(nx,ny));
                                    visited[nx][ny] = true;
                                }else if((maps[p.x][p.y] == 'G' || maps[p.x][p.y] == 'R') && maps[nx][ny] != 'B'){
                                    queue.add(new Point(nx,ny));
                                    visited[nx][ny] = true;
                                }

                            }
                        }
                    }
                }
            }
        }
        System.out.println(area1+" "+area2);
    }
}
