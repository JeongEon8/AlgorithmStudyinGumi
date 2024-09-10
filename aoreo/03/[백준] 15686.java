import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
  static int[] selIdx;
  static int curChicken = 0;
  static int N;
  static int M;
  static Point[] chicken;
  static int[][] maps;
  static int answer = Integer.MAX_VALUE;
  static Point[] home;
  static int homeCnt = 0;
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    maps = new int[N][N];
    curChicken = 0;
    answer = Integer.MAX_VALUE;
    chicken = new Point[14];
    home = new Point[2*N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(bf.readLine());
      for (int j = 0; j < N; j++) {
        maps[i][j] = Integer.parseInt(st.nextToken());  
        if(maps[i][j] == 2) {
          chicken[curChicken] = new Point(i,j);
          curChicken += 1;
        }else if(maps[i][j] == 1) {
          home[homeCnt] = new Point(i,j);
          homeCnt += 1;
        }
      }
    }
    if(curChicken == M) {
      //치킨집 폐업 X
      findChickenDis();
    }else {
      // 폐업할 치킨집 고르기 -> 나머지는 살림
      // 고르면 해당 index는 제일 마지막 index값이랑 변경하고, null 처리하기
      // comb? curChicken - M 만큼 폐업해야함
        selIdx = new int[curChicken-M];
        comb(0, 0);
    }
    System.out.println(answer);
  }

  static void comb(int idx, int r) {
    if(r == curChicken - M) {
      // 다 뽑았당
      for (int i = 0; i < selIdx.length; i++) {
        Point p = chicken[selIdx[i]];
        maps[p.x][p.y] = 0; // 빈칸으로 변경
      }
      findChickenDis();
      for (int i = 0; i < selIdx.length; i++) {
        Point p = chicken[selIdx[i]];
        maps[p.x][p.y] = 2; // 치킨집으로 변경
      } // 다시 복귀
      return;
    }
    for (int i = idx; i < curChicken; i++){
      selIdx[r] = i;
      comb(i+1, r+1);
    }
  }

  static void findChickenDis() {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,-1,1};
    int tmpDis = 0;
    for (int i = 0; i < homeCnt; i++) {
        Point p = home[i];
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);
        boolean[][] visited = new boolean[N][N];
        visited[p.x][p.y] = true;
        while(queue.size() != 0) {
            Point cur = queue.poll();
            if(maps[cur.x][cur.y] == 2){
                tmpDis += Math.abs(cur.x-p.x)+Math.abs(cur.y-p.y);
                queue.clear();
                break;
        }
        for (int j = 0; j < 4; j++) {
          int nextX = cur.x + dx[j];
          int nextY = cur.y + dy[j];
          
          if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;

          if(visited[nextX][nextY] == false){
            queue.add(new Point(nextX, nextY));
            visited[nextX][nextY] = true;
          }
        }
      }
      if(tmpDis >= answer) break;
    }
    if(tmpDis < answer) answer = tmpDis;
  }
}
