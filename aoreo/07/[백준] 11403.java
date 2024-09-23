import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int N = Integer.parseInt(st.nextToken());

    int[][] arr = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(bf.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int k = 0; k < N; k++) {
      for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
              if (arr[i][k] == 1 && arr[k][j] == 1) {
                  arr[i][j] = 1;
              }
          }
      }
  }
  
  for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
          System.out.print(arr[i][j] + " ");
      }
      System.out.println("");
  }

  }
}
