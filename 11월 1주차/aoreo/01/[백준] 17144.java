import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    static int[][] maps;
    static int R;
    static int C;
    static Point[] purifier;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int time = 0;
        maps = new int[R][C];

        purifier = new Point[2];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < C; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if(maps[i][j] == -1){
                    if(purifier[0] == null){
                        purifier[0] = new Point(i,j);
                    }else{
                        purifier[1] = new Point(i,j);
                    }
                }
            }
        }

        while(time < T){
            time += 1;
            diffusion();
            purifierWork();
        }
        int result = countDust();

        System.out.println(result);
    }

    static void diffusion(){
        int[][] tmp = new int[R][C];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(maps[i][j] == -1) {
                    tmp[i][j] = -1;
                    continue;
                }
                tmp[i][j] += maps[i][j];

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if(maps[nx][ny] == -1) continue;

                    tmp[nx][ny] += (maps[i][j] / 5);
                    tmp[i][j] -= (maps[i][j] / 5);
                }
            }
        }
        for (int i = 0; i < R; i++) {
            maps[i] = tmp[i].clone();
        }
    }
    static void purifierWork(){
      
      for(int i = purifier[0].x-1; i > 0; i--) {  // 하
        maps[i][0] = maps[i-1][0];
      }

      for (int i = 0; i < C-1; i++) { // 좌
        maps[0][i] = maps[0][i+1];
      }

      for (int i = 0; i < purifier[0].x; i++) { // 상
        maps[i][C-1] = maps[i+1][C-1];
      }

      // 우
      for (int i = C-1; i > 1; i--) {
        maps[purifier[0].x][i] = maps[purifier[0].x][i-1];
      }

      maps[purifier[0].x][1] = 0; 


      // 상
      for (int i = purifier[1].x+1; i < R-1; i++) { 
        maps[i][0] = maps[i+1][0];
      }

      for (int i = 0; i < C-1; i++) { // 좌
        maps[R-1][i] = maps[R-1][i+1];
      }

      // 하
      for(int i = R-1; i > purifier[1].x; i--) { 
        maps[i][C-1] = maps[i-1][C-1];
      }

      // 우
      for (int i = C-1; i > 1; i--) { 
        maps[purifier[1].x][i] = maps[purifier[1].x][i-1];
      }

      maps[purifier[1].x][1] = 0;
    }

    static int countDust(){
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(maps[i][j] > 0) cnt += maps[i][j];
            }
        }
        return cnt;
    }
  }
