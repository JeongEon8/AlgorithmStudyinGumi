import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[][] maps = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(bf.readLine());
      for (int j = 0; j < M; j++) {
        maps[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(bf.readLine());
    
    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};

    int[][] dices = new int[3][4];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 4; j++) {
        if(i == 1 || j == 1) dices[i][j] = 0;
        else dices[i][j] = -1;
      }
    } // -1로 초기화

    int nx = x;
    int ny = y;
    for (int k = 0; k < K; k++) {
      int command = Integer.parseInt(st.nextToken())-1;
      nx += dx[command];
      ny += dy[command];
      if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
        nx -= dx[command];
        ny -= dy[command];
        continue;
      }

      switch(command){
        case 0:
        int last = dices[1][3];
        for (int i = 2; i >= 0; i--) {
          dices[1][i+1] = dices[1][i];
        }
        dices[1][0] = last;
        break;
        case 1:
        int first = dices[1][0];
        for (int i = 1; i < 4; i++) {
          dices[1][i-1] = dices[1][i];
        }
        dices[1][3] = first;
        break;
        case 2:
        first = dices[0][1];
        dices[0][1] = dices[1][1];
        dices[1][1] = dices[2][1];
        dices[2][1] = dices[1][3];
        dices[1][3] = first;
        break;
        case 3:
        last = dices[1][3];
        dices[1][3] = dices[2][1];
        dices[2][1] = dices[1][1];
        dices[1][1] = dices[0][1];
        dices[0][1] = last;
        break;
      }
      if(maps[nx][ny] == 0) maps[nx][ny] = dices[1][3];
      else {
        dices[1][3] = maps[nx][ny];
        maps[nx][ny] = 0;
      }
      System.out.println(dices[1][1]);
    }
  }
}
