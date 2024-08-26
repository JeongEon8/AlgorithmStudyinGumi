import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



class Main{
    
  static Character [][] maps;
  static int answer = Integer.MAX_VALUE;
  static int N;
  static int M;
  static int hit = 0;
  static int[] dx = {-1,1,0,0};
  static int[] dy = {0,0,1,-1};
  static int[][][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(bf.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    maps = new Character[N][M];

    visited = new int[N][M][2];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(bf.readLine());
      String str = st.nextToken();
        for (int j = 0; j < M; j++) {
            maps[i][j] = str.charAt(j);
        }
    }

    visited[0][0][0] = 1;
    answer = bfs();
    System.out.println(answer);
  }


  static int bfs() {
    int answer = -1;
    Queue<int[]> queue = new LinkedList<>();
    // queue에 이동가능한 좌표 넣어두고, 해당 좌표에 대한 정보는 visited에서 꺼내오기
    int[] start = {0,0,0}; // 0번째가 x좌표, 1번째가 y좌표, 2번째가 벽 부순 여부(0이 안 부숨, 1이 부숨)
    queue.add(start);

    while(queue.size() != 0) {
        int[] q = queue.poll();

        if(q[0] == N - 1 && q[1] == M - 1) {
            queue.clear();
            answer = visited[q[0]][q[1]][q[2]];
            break;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = q[0] + dx[i];
            int nextY = q[1] + dy[i];
            int hit = q[2];

            if(nextX > -1 && nextX < N && nextY > -1 && nextY < M && maps[nextX][nextY] == '0' && visited[nextX][nextY][hit] == 0) {
                int[] tmp = {nextX, nextY, hit};
                queue.add(tmp);
                visited[nextX][nextY][hit] = visited[q[0]][q[1]][hit]+1;

            }else if(nextX > -1 && nextX < N && nextY > -1 && nextY < M && maps[nextX][nextY] == '1' && visited[nextX][nextY][hit] == 0 && hit == 0){
                int[] tmp = {nextX, nextY, 1};
                queue.add(tmp);
                visited[nextX][nextY][1] = visited[q[0]][q[1]][0]+1;
            }
    }
  }
  return answer;
}
}
