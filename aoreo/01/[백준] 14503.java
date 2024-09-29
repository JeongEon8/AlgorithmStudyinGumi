import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
  public static void main(String[] args) throws Exception{
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};

// d 북-> 동 -> 남 -> 서 (dx 순서대로)

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(bf.readLine());
    
    Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    
    int d = Integer.parseInt(st.nextToken());

    int answer = 0;

    int[][] maps = new int[N][M];
    for (int i = 0; i < N; i++) {
        st = new StringTokenizer(bf.readLine());
        for (int j = 0; j < M; j++) {
            maps[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    Queue<Point> queue = new LinkedList<>();
    queue.add(start);
    int[][] visited = new int[N][M];
    visited[start.x][start.y] = 1;

    int curDir = d;

    while(queue.size() != 0){
        Point p = queue.poll();
        boolean canSweep = false;
        Point next = new Point(-1,-1);
        for (int i = 1; i <= 4; i++) { // 사방향 탐색하며 청소할 수 있는 곳 있는지 찾기
            int nx = p.x + dx[(4+curDir-i)%4];
            int ny = p.y + dy[(4+curDir-i)%4];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            if(maps[nx][ny] == 0 && visited[nx][ny] == 0){ // 청소할 수 있다면
                canSweep = true;
                next.x = nx;
                next.y = ny;
                queue.add(next);
                visited[next.x][next.y] = visited[p.x][p.y] + 1;
                curDir = (4+curDir-i)%4;
                break;
            }
        }
        if(canSweep == false){
            int tmp = (curDir+2)%4;
            int nx = p.x + dx[tmp];
            int ny = p.y + dy[tmp];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(maps[nx][ny] == 0){
                queue.add(new Point(nx,ny));
                visited[nx][ny] = visited[p.x][p.y];
             }else{
                queue.clear();
                answer = visited[p.x][p.y];
                break;
            }           
        }
    }
    System.out.println(answer);
    }
}
