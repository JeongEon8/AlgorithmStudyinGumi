import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int N = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(bf.readLine());
    int K = Integer.parseInt(st.nextToken());
  
    int[][] maps = new int[N][N];
    ArrayList<Point> list = new ArrayList<>(); // 뱀이 차지하고 있는 위치

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(bf.readLine());
      maps[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1; // 사과가 있으면 1, 0이면 빈칸
    }

    st = new StringTokenizer(bf.readLine());
    int L = Integer.parseInt(st.nextToken());
    
    Point[] dirs = new Point[L]; // 뱀 방향 변환
    for (int i = 0; i < L; i++) {
      st = new StringTokenizer(bf.readLine());
      dirs[i] = new Point();
      dirs[i].x = Integer.parseInt(st.nextToken());
      if(st.nextToken().equals("D")) dirs[i].y = 0; // 오른쪽
      else dirs[i].y = 1; // 왼쪽
    }

    int nx = 0, ny = 0; 
    int time = 1;
    int idx = 0;
    int dir = 1; // 0 - 상, 1 - 우, 2 - 하, 3 - 좌 
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    list.add(new Point(nx,ny));
    while(true){
        nx += dx[dir];
        ny += dy[dir];
        if(nx < 0 || nx >= N || ny < 0 || ny >= N) break; // 벽에 부딪히면 게임 끝
        if(list.contains(new Point(nx,ny))) break; // 자기 몸에 부딪히면 게임 끝
      if(maps[nx][ny] == 0 && list.isEmpty() == false){ // 사과없음
        list.remove(list.size()-1); // 마지막 거 삭제 지나간 영역
      }else{
        maps[nx][ny] = 0; // 사과먹음
      }
      list.add(0,new Point(nx,ny));

      if(idx < dirs.length && dirs[idx].x == time){ // 방향 전환해야함
        if(dirs[idx].y == 0){ // 오른쪽으로 전환
            dir = (dir+1)%4;
        }else{
            dir = (dir+3)%4;
        }
        idx += 1;
    }
    time += 1;
    }

    System.out.println(time);
  }
}
