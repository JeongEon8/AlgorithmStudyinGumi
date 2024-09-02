import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
 
    int T = Integer.parseInt(st.nextToken());
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
      st = new StringTokenizer(bf.readLine());
      int N = Integer.parseInt(st.nextToken());
      int[] corridors = new int[200];
      int[][] students = new int[N][2]; // [0][0] = 10, [0][1] = 20
 
      for (int i = 0; i < N; i++) {
          st = new StringTokenizer(bf.readLine());
          students[i][0] = (Integer.parseInt(st.nextToken())-1)/2;
          students[i][1] = (Integer.parseInt(st.nextToken())-1)/2;
      }
      int max = 0;
      for (int i = 0; i < N; i++) {
        if(students[i][0] > students[i][1]) {
          for (int j = students[i][1]; j < students[i][0]+1; j++){
            corridors[j] += 1;
            if(max < corridors[j]) max = corridors[j];
          }
        }else{
          for (int j = students[i][0]; j < students[i][1]+1; j++){
            corridors[j] += 1;
            if(max < corridors[j]) max = corridors[j];
          }
        }
 
      }
 
 
      System.out.println("#"+test_case+" "+max);
        }
    }
}
