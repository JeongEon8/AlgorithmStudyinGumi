import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
  static int[][] cloned;
  static int N;
  static int[][] maps;
  static int[] dx = {-1,1,0,0};
  static int[] dy = {0,0,-1,1};
  static int maxCnt = 0;
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    N = Integer.parseInt(st.nextToken());

    maps = new int[N][N];
    int max = 0;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(bf.readLine());
      for (int j = 0; j < N; j++) {
        maps[i][j] = Integer.parseInt(st.nextToken());
        if(max < maps[i][j]) max = maps[i][j];
      }        
    }
    for (int i = 0; i < max; i++) {
        makeClone(i);
        maxCnt = Math.max(findArea(), maxCnt);
    }

    System.out.println(maxCnt);
  }

  static void makeClone(int height){
    cloned = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        cloned[i][j] = maps[i][j] - height;
      }
    }
  }

  static int findArea() {
    boolean[][] visited = new boolean[N][N];
    int area = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if(cloned[i][j] > 0 && visited[i][j] == false){
          Queue<Point> queue = new LinkedList<>();
          queue.add(new Point(i,j));
          area += 1;
          while(queue.size() != 0){
            Point p = queue.poll();
            for (int k = 0; k < 4; k++) {
              int nx = p.x + dx[k];
              int ny = p.y + dy[k];
              if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

              if(cloned[nx][ny] > 0 && visited[nx][ny] == false) {
                visited[nx][ny] = true;
                queue.add(new Point(nx,ny));
              }
            }
          }
        }
      }
    }
    return area;
  }
}
