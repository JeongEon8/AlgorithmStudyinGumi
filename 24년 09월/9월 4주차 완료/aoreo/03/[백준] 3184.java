import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};

    Character[][] maps = new Character[R][C];
    boolean[][] visited = new boolean[R][C];

    int wolfCnt = 0;
    int sheepCnt = 0;

    for(int i = 0; i < R; i++){
      String str = new StringTokenizer(bf.readLine()).nextToken();
      for (int j = 0; j < C; j++) {
        maps[i][j] = str.charAt(j);
      }
    }

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if(visited[i][j] == false && maps[i][j] != '#'){
          int wCnt = 0;
          int sCnt = 0;
          switch(maps[i][j]){
            case 'o' : sCnt += 1;
            break;
            case 'v' : wCnt += 1;
            break;
          }
          visited[i][j] = true;
          Queue<Point> queue = new LinkedList<>();
          queue.add(new Point(i,j));

          while(queue.size() != 0) {
            Point p = queue.poll();
            for (int k = 0; k < 4; k++) {
              int nx = p.x + dx[k];
              int ny = p.y + dy[k];

              if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

              if(visited[nx][ny] == false && maps[nx][ny] != '#'){
                visited[nx][ny] = true;
                queue.add(new Point(nx,ny));
                if(maps[nx][ny] == 'o') sCnt += 1;
                else if(maps[nx][ny] == 'v') wCnt += 1;
              }
            }
          }
          if(sCnt > wCnt) sheepCnt += sCnt;
          else wolfCnt += wCnt;
        }
      }
    }

    System.out.println(sheepCnt+" "+wolfCnt);
  }
}
