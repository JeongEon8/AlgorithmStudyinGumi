import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int F = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken())-1;
    int G = Integer.parseInt(st.nextToken())-1;
    int U = Integer.parseInt(st.nextToken());
    int D = Integer.parseInt(st.nextToken());
  
    Queue<Integer> queue = new LinkedList<>();
    queue.add(S);

    int[] visited = new int[F];
    visited[S] = 1;

    int answer = -1;

    while(queue.size() != 0) {
      int cur = queue.poll();

      if(cur == G) {
        queue.clear();
        answer = visited[G];
        break;
      }
      if(checkRange(cur+U, F) == true && visited[cur+U] == 0){
        queue.add(cur+U);
        visited[cur+U] = visited[cur] + 1;
      } 
      if(checkRange(cur-D, F) == true && visited[cur-D] == 0) {
        queue.add(cur-D);
        visited[cur-D] = visited[cur] + 1;
      }
    }
    answer = visited[G];
    if(answer == 0) System.out.println("use the stairs");
    else System.out.println(answer-1);
  }

  static boolean checkRange(int x, int F){
    if(x >= 0 && x < F) return true;
    else return false;
  }
}
