import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(bf.readLine());

    int K = Integer.parseInt(st.nextToken()) -1; // 시작점

    ArrayList<Node>[] graph = new ArrayList[V]; // 인접 노드들
    for (int i = 0; i < V; i++) {
        graph[i] = new ArrayList<>();
    }
    int[] dists = new int[V];
    Arrays.fill(dists, Integer.MAX_VALUE); // INF로 초기화
    dists[K] = 0;

    PriorityQueue<Node> pQueue = new PriorityQueue<>();
    boolean[] visited = new boolean[V];

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(bf.readLine());
      int u = Integer.parseInt(st.nextToken())-1;
      int v = Integer.parseInt(st.nextToken())-1;
      int w = Integer.parseInt(st.nextToken());
      if(u == K) {
        pQueue.add(new Node(K, 0));
      }

      graph[u].add(new Node(v, w));
    }

    

    while(pQueue.size() != 0){
      Node node = pQueue.poll();
      if(visited[node.idx] == true) continue;
      visited[node.idx] = true;
      for (Node next : graph[node.idx]) {
          if(next.cost + dists[node.idx] < dists[next.idx]) {
            // 방문한 적 없거나, 더 가까운 길이 발견된 경우
            dists[next.idx] = next.cost + dists[node.idx];
            pQueue.add(new Node(next.idx, dists[next.idx]));
          }
      }
    }

    for (int i = 0; i < V; i++) {
      if(dists[i] == Integer.MAX_VALUE) System.out.println("INF");
      else System.out.println(dists[i]);
    }
  }

  static class Node implements Comparable<Node>{
    int idx;
    int cost;

    public Node(int idx, int cost) {
      this.idx = idx;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      if(this.cost < o.cost) return -1;
      else return 1;
    }
  }
}
