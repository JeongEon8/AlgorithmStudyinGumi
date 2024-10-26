import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
  static int[] sel;
  static boolean[] visited;
  static int K, N, M;
  static int[][] maps;
  static int[][] command;
  static int answer = Integer.MAX_VALUE;
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    maps = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(bf.readLine());
      for (int j = 0; j < M; j++) {
        maps[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    command = new int[K][3];
    sel = new int[K];
    visited = new boolean[K];
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(bf.readLine());
      command[i][0] = Integer.parseInt(st.nextToken()) -1; // r
      command[i][1] = Integer.parseInt(st.nextToken()) -1; // c
      command[i][2] = Integer.parseInt(st.nextToken()); // s
    }

    comb(0, 0);
    System.out.println(answer);
  }

  static void comb(int idx, int depth){
    if(depth == K){
      // 다 뽑았당
      // System.out.println(Arrays.toString(sel));
      int [][] tmp = new int[N][M];
      for (int j = 0; j < N; j++) {
        tmp[j] = maps[j].clone();
      }
      for (int i = 0; i < K; i++) {
        int r = command[sel[i]][0];
        int c = command[sel[i]][1];
        int s = command[sel[i]][2];

        int lx = r+s; // 내 그림 기준 n
        int ly = c+s; // 내 그림 기준 m
        int sx = r-s;
        int sy = c-s;

        tmp = rotate(tmp, s, lx, ly, sx, sy);
      }
      int result = findMin(tmp);
      answer = Math.min(result, answer);
      return;
    }

    for (int i = 0; i < K; i++) {
      if(visited[i] == false){
        visited[i] = true;
        sel[depth] = i;
        comb(i+1, depth+1);
        visited[i] = false;
      }

    }
  }

  static int[][] rotate(int[][] arrs, int s, int lx, int ly, int sx, int sy){
    int idx = 0;
    while(s - idx >= 1) {
      // 제일 상단 줄 오른쪽으로 옮기기
      int topRight = arrs[sx+idx][ly - idx];
      for (int j = ly - idx; j > sy + idx ; j--) {
        arrs[sx+idx][j] = arrs[sx+idx][j-1];
      }     
      
      // 오른쪽 줄 아래로 옮기기
      int bottomRight = arrs[lx-idx][ly-idx];
      for (int j = lx-idx; j > sx+idx; j--) {
        arrs[j][ly-idx] = arrs[j-1][ly-idx];
      }

      arrs[sx+idx+1][ly-idx] = topRight;

      // 아래 줄 왼쪽으로 옮기기
      int bottomLeft = arrs[lx-idx][sy+idx];
      for (int j = sy+idx; j < ly-idx; j++) {
        arrs[lx-idx][j] = arrs[lx-idx][j+1];
      }

      arrs[lx-idx][ly-idx-1] = bottomRight;


      // 왼쪽 줄 위로 옮기기
      int topLeft = arrs[sx+idx][sy+idx];
      for (int j = sx+idx; j < lx-idx; j++) {
        arrs[j][sy+idx] = arrs[j+1][sy+idx];
      }

      arrs[lx-idx-1][sy+idx] = bottomLeft;

      arrs[sx+idx][sy+idx+1] = topLeft;

      idx += 1;
    }
    return arrs;
    // System.out.println(Arrays.deepToString(arrs));
  }

  static int findMin(int[][] arrs){
    int sum = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      int tmp = 0;
      for (int j = 0; j < M; j++) {
        tmp += arrs[i][j];
      }
      sum = Math.min(sum, tmp);
    }
    return sum;
  }
}

// (r-s, c-s) ---- (r-s, c+s)
// (r+s, c-s) ---- (r+s, c+s)

// (n == m)이 2s
// 2s - 2i == 1 이 될 때까지 반복하면서 회전시키기
// (i, m-i)을 기록해두고 (r-s + i, c-s + i) 부터 (r-s + i, c-s + m-i)까지 +1 씩 이동시키기
// (r-s + n-i, c-s + m-i)을 기록해두고 (r-s +i, c-s + m-i)부터 (r-s + n -i, c-s + m-i) 까지 +1씩 이동시키기
// (n-i, i)을 기록해두고 (n-i, m-i) 부터 (n-i, i)까지 -1씩 이동시키기
// (i, i)을 기록해두고 (n-i, i) 부터 (i, i)까지 -1씩 이동시키기

