import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
  static int[] sel;
  static int N;
  static int[][] scores;
  static int answer = Integer.MAX_VALUE;
  static ArrayList<Integer> all = new ArrayList<Integer>();
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    N = Integer.parseInt(st.nextToken());

    scores = new int[N][N];
    sel = new int[N/2];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(bf.readLine());
      all.add(i);
      for (int j = 0; j < N; j++) {
        scores[i][j] = Integer.parseInt(st.nextToken());  
      }  
    }

    comb(0, 0);
    System.out.println(answer);
  }

  static public void comb(int idx, int r) {
    if(r == (N/2)){
      int sum = 0;
      for (int i = 0; i < sel.length-1; i++) {
        for(int j = i + 1; j < sel.length; j++) {
          sum += scores[sel[i]][sel[j]];
          sum += scores[sel[j]][sel[i]];
        }
      }
      int oppSum = 0;
      ArrayList<Integer> tmp = new ArrayList<Integer>();
      tmp = (ArrayList<Integer>) all.clone();
      for(int e : sel) {
        tmp.remove(Integer.valueOf(e));
      } 
      
      for (int i = 0; i < N/2-1; i++) {
        for (int j = i+1; j < N/2; j++) {
          oppSum += scores[tmp.get(i)][tmp.get(j)];
          oppSum += scores[tmp.get(j)][tmp.get(i)];  
        }
      }
      if(answer > Math.abs(oppSum-sum)) answer = Math.abs(oppSum - sum);
      return;
    }
    for (int i = idx; i < N; i++) {
      sel[r] = i;
      comb(i+1, r+1);   
    }
  }
}
