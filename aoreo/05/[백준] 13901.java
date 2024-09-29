import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
  static int[][] maps;
  static int[] dx = {-1,1,0,0};
  static int[] dy = {0,0,-1,1};
  static int[] dirs;
  static int R;
  static int C;
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    R = Integer.parseInt(st.nextToken()); 
    C = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(bf.readLine());
    int K = Integer.parseInt(st.nextToken()); // 장애물 개수
    
    maps = new int[R][C];

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(bf.readLine());
      maps[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
    }
    
    st = new StringTokenizer(bf.readLine());
    int sx = Integer.parseInt(st.nextToken());
    int sy = Integer.parseInt(st.nextToken());

    dirs = new int[4];

    st = new StringTokenizer(bf.readLine());
    for (int i = 0; i < 4; i++) {
      dirs[i] = Integer.parseInt(st.nextToken())-1;
    }

    maps[sx][sy] = 1;

    int cnt = 0;
    int curDir = 0;
    int cx = sx;
    int cy = sy;

    while(true) {
      int nx = cx + dx[dirs[curDir]];
      int ny = cy + dy[dirs[curDir]];
      if(checkRange(nx, ny) == true && maps[nx][ny] == 0){
        maps[nx][ny] = 1;
        cnt = 0;
        cx = nx;
        cy = ny;
      } else {
        cnt += 1;
        curDir = (curDir+1) % 4;
      }
      if(cnt == 4) break;
    }
    System.out.println(cx+ " "+cy);
  }

  static boolean checkRange(int x, int y){
    if(x < 0 || x >= R || y < 0 || y >= C) return false;
    return true;
  }
}
