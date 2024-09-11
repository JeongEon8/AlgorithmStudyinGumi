import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
  static int[][] arr;
  static int N;
  static int max;
    public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    N = Integer.parseInt(st.nextToken());
    arr = new int[N][2];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(bf.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }
    recur(0, 0);
    System.out.println(max);
  }

  static void recur(int day, int sum){
    if(day == N) {
      if(max < sum) max = sum;
      return;
    }
    if(day + arr[day][0] <= N) recur(day+arr[day][0], sum + arr[day][1]); // 했을 때
    recur(day+1, sum); 
  }
}
