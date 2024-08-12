import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
      int tc = sc.nextInt();
      ArrayList<Integer>[] links = new ArrayList[100];
      boolean[] visited = new boolean[100];
      Queue<Integer> queue = new LinkedList<>();
      
      int ways = sc.nextInt();
      int answer = 0;

      for (int i = 0; i < ways*2 ; i+=2) {
        int start = sc.nextInt();
        int end = sc.nextInt();
        if (links[start] == null){
          links[start] = new ArrayList<>();
        }
        links[start].add(end);
      }
      
      for (int j = 0; j < links[0].size(); j++) {
        queue.add(links[0].get(j));
        visited[j] = true;
      }
      visited[0] = true;
      while (!queue.isEmpty()) { 
        int s = queue.poll();

        if (links[s] != null) {
          for (int k = 0; k<links[s].size();k++) {
            if (visited[links[s].get(k)] == false){
              queue.add(links[s].get(k));
              visited[links[s].get(k)] = true;
              if (links[s].get(k) == 99) {
                answer = 1;
                queue.clear();
                break;
              }
            }
          }
        }
      }      
    System.out.println("#"+test_case+" "+answer);
  }
	}
}
