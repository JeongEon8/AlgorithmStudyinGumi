import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
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
      int V = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
 
      boolean[] visited = new boolean[V];
      ArrayList<Node>[] graph = new ArrayList[V];
      long answer = 0;
 
      PriorityQueue<Node> pQueue = new PriorityQueue<>();
      for (int i = 0; i < E; i++) {
        st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken())-1;
        int b = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken());
        if(graph[a] == null) {
          ArrayList<Node> tmp = new ArrayList<>();
          tmp.add(new Node(b, c));
          graph[a] = tmp;
        }else graph[a].add(new Node(b,c));
 
        if(graph[b] == null) {
          ArrayList<Node> tmp = new ArrayList<>();
          tmp.add(new Node(a,c));
          graph[b] = tmp;
        }else graph[b].add(new Node(a, c));
      }
 
      for (int j = 0; j < graph[0].size(); j++) {
        pQueue.add(graph[0].get(j));
      }
      visited[0] = true;
 
      while(pQueue.size() != 0) {
        Node n = pQueue.poll();
        if(visited[n.next] == false) {
          visited[n.next] = true;
          answer += n.weight;
          for (int i = 0; i < graph[n.next].size(); i++) {
              pQueue.add(graph[n.next].get(i));
          }
        }
      }
      System.out.println("#"+test_case+" "+answer);
     
    }
}
 
static class Node implements Comparable<Node>{
  int next;
  int weight;
 
  public Node(int next, int weight) {
    this.next = next;
    this.weight = weight;
  }
 
  @Override
  public int compareTo(Node o) {
    return weight - o.weight;
  }
}
}
