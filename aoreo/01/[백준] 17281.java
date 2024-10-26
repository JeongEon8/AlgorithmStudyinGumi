import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
  static int[] sel = new int[9];
  static boolean [] visited = new boolean[9];
  static int[][] arr;
  static int maxScore = 0;
  static int N = 0;
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    N = Integer.parseInt(st.nextToken());

    arr = new int[N][9];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(bf.readLine());
      for (int j = 0; j < 9; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    makeOrder(0);
    System.out.println(maxScore);
  }

  private static void makeOrder(int r){
    if(r == 8) {
      // 게임진행하기
      sel[3] = 0;
      game();
      return;
    }
    for (int i = 1; i < 9; i++) {
      if(visited[i] == false) {
        visited[i] = true;
        if(r >= 3) sel[r+1] = i;
        else sel[r] = i;
        makeOrder(r+1);
        visited[i] = false;
      }
    }
  }

  private static void game(){
    int out = 0;
    int round = 0;

    int index = 0;

    int score = 0;

    boolean[] base = new boolean[3]; // 0번이 1루, 1번이 2루, 2번이 3루에 사람이 있는지 여부

    while(round < N) {
      switch(arr[round][sel[index]]) {
        case 0 : // 아웃
          out += 1;
        break;
        case 1 : // 안타 
          if(base[2] == true) { // 3루에 있던 사람 홈으로 진루
            score += 1;
            base[2] = false;
          }
          if(base[1] == true) { // 2루에 있던 사람 3루로 진루
            base[2] = true;
            base[1] = false;
          }
          if(base[0] == true) { // 1루에 있던 사람 2루로 진루
            base[1] = true;
            base[0] = false;
          }
          // for (int i = 2; i > 0; i--) {
          //   if(i == 2 && base[i] == true) {
          //     score += 1;
          //   }
          //   base[i] = base[i-1];
          // }
          base[0] = true; // 타자 1루로 진루
        break;
        case 2 : // 2루타
          if(base[2] == true) { // 3루에 있던 사람 홈으로 진루
            score += 1;
            base[2] = false;
          }
          if(base[1] == true) { // 2루에 있던 사람 홈으로 진루
            score += 1;
            base[1] = false;
          }
          if(base[0] == true) { // 1루에 있던 사람 3루로 진루
            base[0] = false;
            base[2] = true;
          }
          base[1] = true; // 타자 2루로 진루
        break;
        case 3 : // 3루타
          if(base[2] == true){ // 3루에 있던 사람 홈으로 진루
            score += 1;
            base[2] = false;
          } 
          if(base[1] == true) { // 2루에 있던 사람 홈으로 진루
            score += 1;
            base[1] = false;
          }
          if(base[0] == true) { // 1루에 있던 사람 홈으로 진루
            score += 1;
            base[0] = false;
          }
          base[2] = true; // 타자 3루로 진루
        break;
        case 4 : // 홈런
          if(base[2] == true) { // 3루에 있던 사람 홈으로 진루
            score += 1;
            base[2] = false;
          }
          if(base[1] == true) { // 2루에 있던 사람 홈으로 진루
            score += 1;
            base[1] = false;
          }
          if(base[0] == true) { // 1루에 있던 사람 홈으로 진루
            score += 1;
            base[0] = false;
          }
          score += 1; // 타자 3루로 진루
        break;
      } 
      if(out == 3) {
        round += 1;
        out = 0;
        for (int i = 0; i < 3; i++) {
          base[i] = false;
        }
      }
      index = (index+1)%9;
    }
  
    maxScore = Math.max(maxScore, score);
  }
}

// 1번부터 8번까지의 순서 배치해야함 -> 순열
// 8!
// 순서 만들면 해당 순서대로 게임진행하면서 아웃 수가 3이면 이닝 종료.
// 이닝이 N이 되면 도달하면 게임 종료하기
