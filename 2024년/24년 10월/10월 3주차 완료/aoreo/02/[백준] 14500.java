import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main{
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int M;
    static int[][] maps;
    static boolean[][] visited;
    static int maxVal = 0;
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    maps = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(bf.readLine());
      for (int j = 0; j < M; j++) {
        maps[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        f(i,j,0,0);
      }
    }

    Point[] pArr1 = {new Point(0,1), new Point(1,0), new Point(1,1), new Point(1,2)};
    Point[] pArr2 = {new Point(0,0), new Point(1,0), new Point(2,0), new Point(1,1)};
    Point[] pArr3 = {new Point(0,0), new Point(0,1), new Point(0,2), new Point(1,1)};
    Point[] pArr4 = {new Point(0,M-1),new Point(1,M-1), new Point(2, M-1), new Point(1,M-2)};

    Point p1 = pArr1[2];
    Point p2 = pArr2[1];

    for(int i = 1; i < N; i++){
        for (int j = 1; j < M-1; j++) {
            int sum = maps[i-1][j] + maps[i][j-1] + maps[i][j] + maps[i][j+1];
            if(sum > maxVal) maxVal = sum;
        }
    }// ㅗ
    for(int i = 1; i < N-1; i++){
        for (int j = 0; j < M-1; j++) {
            int sum = maps[i][j+1] + maps[i+1][j] + maps[i-1][j] + maps[i][j];
            if(sum > maxVal) maxVal = sum;
        }
    } // ㅏ

    for(int i = 0; i < N-1; i++){
        for (int j = 1; j < M-1; j++) {
            int sum = maps[i][j-1] + maps[i+1][j] + maps[i][j+1] + maps[i][j];
            if(sum > maxVal) maxVal = sum;
        }
    } // ㅜ

    for(int i = 1; i < N-1; i++){
        for (int j = M-1; j > 0; j--) {
            int sum = maps[i][j-1] + maps[i+1][j] + maps[i-1][j] + maps[i][j];
            if(sum > maxVal) maxVal = sum;
        }
    } // ㅓ

    System.out.println(maxVal);
  }
  
  static void f(int x, int y, int r, int sum){
    if(r == 4) {
        if(maxVal < sum) maxVal = sum;
        return;
    }

    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

        if(visited[nx][ny] == false) {
            visited[nx][ny] = true;
            f(nx,ny,r+1,sum+maps[nx][ny]);
            visited[nx][ny] = false;
        }
    }
  }
}
