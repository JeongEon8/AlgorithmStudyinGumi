import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    static int[] sel = new int[3];
    static int[][] maps;
    static int[][] copyMaps;
    static int M;
    static int N;
    static int D;
    static int answer;
    static int[] dx = {0,-1,0};
    static int[] dy = {-1,0,1};
    static int round = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        maps = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(0,0);
        System.out.println(answer);
    }

    static void comb(int idx, int r){
        if(r == 3) {
            // System.out.println("-------------new game start--------");
            // System.out.println("sel "+Arrays.toString(sel));
            init();
            attack();
            return;
        }
        for (int i = idx; i < M; i++) {
            sel[r] = i;
            comb(i+1, r+1);
        }
    }

    static void init(){
      copyMaps = new int[N][M];
      for (int i = 0; i < N; i++) {
        copyMaps[i] = maps[i].clone();
      }
      round = 0;
    }

    static void attack(){
        int kills = 0;
        
        while(round < N) {
          // System.out.println("----- new round -----");
          // System.out.println(Arrays.deepToString(copyMaps));
            Move[] enemies = new Move[3];
        
            for (int i = 0; i < sel.length; i++) {
                int sx = N;
                int sy = sel[i];
                Queue<Move> queue = new LinkedList<>();
                queue.add(new Move(sx, sy, 0));
                while(queue.size() != 0) {
                  Move m = queue.poll();
                  if(m.move >= D) continue;
                  for (int j = 0; j < 3; j++) {
                      int nx = m.x + dx[j];
                      int ny = m.y + dy[j];

                      if(nx < 0 || ny < 0 || nx >= N || ny >= M || maps[nx][ny] == -1) continue;

                      if(copyMaps[nx][ny] == 1) {
                        if(enemies[i] == null) enemies[i] = new Move(nx, ny, m.move+1);
                        else if((enemies[i].y > ny && enemies[i].move == (m.move+1)) || enemies[i].move > (m.move+1)) enemies[i] = new Move(nx, ny, m.move+1);
                        // System.out.println("enemies[i] "+i+" "+enemies[i].toString());
                      }else if(copyMaps[nx][ny] == 0){
                        queue.add(new Move(nx, ny, m.move+1));
                      }
                  }
                }
            }
    
            for (int i = 0; i < enemies.length; i++) {
                if(enemies[i] != null){
                    if(copyMaps[enemies[i].x][enemies[i].y] == 1){
                        copyMaps[enemies[i].x][enemies[i].y] = 0;
                        kills += 1;
                    }
                }
            }
            round += 1;
            
            // System.out.println("copyMaps "+Arrays.deepToString(copyMaps));
            // System.out.println("kills "+kills );
            for (int i = N-1; i >= 0; i--) {
                for (int j = 0; j < M; j++) {
                    if(i < round) {
                        copyMaps[i][j] = -1;
                    }else{
                        copyMaps[i][j] = copyMaps[i-1][j];
                    }
                }
            }

        }
        if(kills > answer) answer = kills;
    }

    static class Move{
      int x;
      int y;
      int move;

      public Move(int x, int y, int move){
        this.x = x;
        this.y = y;
        this.move = move;
      }

      @Override
      public String toString(){
        return "x : "+x+" y "+y+" move "+move;
      }
    }
}
