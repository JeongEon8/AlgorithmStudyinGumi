import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    boolean[][] maps = new boolean[M][N];

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(bf.readLine());
      int ly = Integer.parseInt(st.nextToken());
      int lx = Integer.parseInt(st.nextToken());
      int ry = Integer.parseInt(st.nextToken());
      int rx = Integer.parseInt(st.nextToken());

      for (int j = lx; j < rx; j++) {
        for (int k = ly; k < ry; k++) {
          maps[j][k] = true;
        }
      }
    }

    int areaCnt = 0;
    PriorityQueue<Integer> areas = new PriorityQueue<>();
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    boolean[][] visited = new boolean[M][N];

    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if(maps[i][j] == false && visited[i][j] == false){
          areaCnt += 1;
          int areaSize = 1;
          Queue<Point> queue = new LinkedList<>();
          queue.add(new Point(i,j));
          visited[i][j] = true;

          while(queue.size() != 0) {
            Point p = queue.poll();
            
            for (int k = 0; k < 4; k++) {
              int nx = p.x + dx[k];
              int ny = p.y + dy[k];

              if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;

              if(visited[nx][ny] == false && maps[nx][ny] == false) {
                queue.add(new Point(nx, ny));
                visited[nx][ny] = true;
                areaSize += 1;
              }
            }
          }
          areas.add(areaSize);
        }
      }
    }

    System.out.println(areaCnt);
    for (int i = 0; i < areaCnt; i++) {
      System.out.print(areas.poll()+" ");
    }
  }
}
