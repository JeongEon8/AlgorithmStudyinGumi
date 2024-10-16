import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());

    int[][][] arr = new int[H][N][M];
    int[][][] visited = new int[H][N][M];

    boolean allDone = true;

    int answer = 0;
    for (int k = 0; k < H; k++) {
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(bf.readLine());
        for (int j = 0; j < M; j++) {
          arr[k][i][j] = Integer.parseInt(st.nextToken()); // 0은 익지 않은 토마토, 1은 익은 토마토, -1은 토마토 없음
          if(allDone == true && arr[k][i][j] == 0) allDone = false;
        }
      } 
    }

    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    int[] dz = {1,-1};

    if(allDone == true) answer = 0;
    else{
      for (int k = 0; k < H; k++) {
        for (int i = 0; i < N; i++) {
          for (int j = 0; j < M; j++) {
            if(arr[k][i][j] == 1){
              Queue<int[]> queue = new LinkedList<>();
              int[] tmp = {k,i,j};
              queue.add(tmp);
              visited[k][i][j] = 1;
              
              while(queue.size() != 0){
                int[] n = queue.poll();
                for (int l = 0; l < 4; l++) {
                  int nx = n[1] + dx[l];
                  int ny = n[2] + dy[l];

                  if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                  if(arr[n[0]][nx][ny] == 0 && (visited[n[0]][nx][ny] == 0 || visited[n[0]][nx][ny] > visited[n[0]][n[1]][n[2]] +1)){
                    int[] t = {n[0],nx,ny};
                    queue.add(t);
                    visited[n[0]][nx][ny] = visited[n[0]][n[1]][n[2]] +1;
                  }
                }

                for (int l = 0; l < 2; l++) {
                  int nz = n[0] + dz[l];

                  if(nz < 0 || nz >= H) continue;

                  if(arr[nz][n[1]][n[2]] == 0 && (visited[nz][n[1]][n[2]] == 0 || visited[nz][n[1]][n[2]] > visited[n[0]][n[1]][n[2]] +1)){
                    int[] t = {nz,n[1],n[2]};
                    queue.add(t);
                    visited[nz][n[1]][n[2]] = visited[n[0]][n[1]][n[2]] +1;
                  }
                }
              }

            }
          }
        } 
      }

      boolean allCheck = true;
      if(allDone == false){
        for (int i = 0; i < N; i++) {
          for (int j = 0; j < M; j++) {
            for (int k = 0; k < H; k++) {
              if(visited[k][i][j] == 0 && arr[k][i][j] == 0) allCheck = false;
              answer = Math.max(answer, visited[k][i][j]-1);
            }
          }
        }
      }
      if(allCheck == false) answer = -1;
    }
    // System.out.println(Arrays.deepToString(visited));
    if(allDone == true) answer = 0;
    System.out.println(answer);
    // 인접하다고 판단하는 건 
    // [H][M+1][N], [h][m-1][n], [h][m][n-1]. [h][m][n+1]
    // [H+1][M][N]
    // [H-1][M][N]
  }
}
