import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int N = Integer.parseInt(st.nextToken());
    int[] order = new int[N*N];
    int[][] seatArr = new int[N][N];
    int[][] favArr = new int[N*N][4];

    for (int i = 0; i < N*N; i++) {
      st = new StringTokenizer(bf.readLine());
      int x = Integer.parseInt(st.nextToken())-1;
      order[i] = x;
      for (int j = 0; j < 4; j++) {
        favArr[x][j] = Integer.parseInt(st.nextToken()) -1;
      }
    }
    int[][] visited = new int[N][N]; // 앉아있는 학생의 번호
    for (int i = 0; i < N; i++) {
        Arrays.fill(visited[i], -1);
    }

    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,1,-1};

    for (int stuNum : order) { // i가 앉을 자리 주인
      PriorityQueue<Seat> pQueue = new PriorityQueue<>();
      for (int l = 0; l < N; l++) {
        for (int m = 0; m < N; m++) {
          if(visited[l][m] == -1){
            // 빈칸 어케 세지 ? 좋아하는 자리 ?
            // bfs로 주변 탐색?
            int blanks = 0;
            int favs = 0;

            for (int n = 0; n < dx.length; n++) {
              int nx = l + dx[n];
              int ny = m + dy[n];

              if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

              if(visited[nx][ny] == -1) blanks += 1;
              else{
                for (int k = 0; k < 4; k++) {
                  if(favArr[stuNum][k] == visited[nx][ny]) favs += 1;
                }
              }
            }
            pQueue.add(new Seat(l, m, favs, blanks));
          }
        }
      }
      Seat s = pQueue.peek();
      visited[s.x][s.y] = stuNum;
    }

    int answer = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int score = 0;
        for (int k = 0; k < dx.length; k++) {
          int nx = i + dx[k];
          int ny = j + dy[k];

          if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

          for (int l = 0; l < 4; l++) {
              if(favArr[visited[i][j]][l] == visited[nx][ny]){
                score += 1;
                break;
              }
          }
        }
        switch(score){
            case 1 : answer += 1;
            break;
            case 2 : answer += 10;
            break;
            case 3 : answer += 100;
            break;
            case 4 : answer += 1000;
            break;
        }
      }
    }
    System.out.println(answer);
  }

  static class Seat implements Comparable<Seat>{
    int x;
    int y;
    int favCnt;
    int blankCnt;

    public Seat(int x, int y, int favCnt, int blankCnt) {
      this.x = x;
      this.y = y;
      this.favCnt = favCnt;
      this.blankCnt = blankCnt;
    }

        @Override
        public int compareTo(Seat o) {
            if(this.favCnt < o.favCnt){
              return 1;
            }else if(this.favCnt == o.favCnt){
              if(this.blankCnt < o.blankCnt) return 1;
              else if(this.blankCnt == o.blankCnt) {
                if(this.x > o.x) return 1;
                else if(this.x == o.x) {
                  if(this.y > o.y) return 1;
                }
              }
            }
            return -1;
        }

        @Override
        public String toString() {
            return "x "+x+" y "+y+" blank "+blankCnt+" fav "+favCnt;
        }
  }
}

// 배열 [N^2][4], [N][N]
// 좋아하는 학생이 가장 많은 + 인접 칸 중 비어있는 칸이 많은 + 행의 번호가 가장 작은 + 열의 번호가 가장 작은 순으로 자리 선택
// 배열 0번부터 탐색하는데, 매 탐색마다 우선순위큐를 쓰고, 정렬기준은 위에걸로 하면?
// 좌석 선택할 땐 가장 앞에 걸 꺼내면 되지 않을까?
