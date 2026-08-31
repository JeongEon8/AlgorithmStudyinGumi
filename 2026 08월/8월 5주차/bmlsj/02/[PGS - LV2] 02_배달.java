import java.util.*;
class Solution {
    
    static class Node implements Comparable<Node> {
        int to, cost;
        
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    static int[] dist;
    static ArrayList<Node>[] graph;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        // n개의 마을 중 k시간 이하로 배달 가능한 마을에서만 주문
        graph = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        dist = new int[N + 1];
        for(int[] r: road) {
            int u = r[0];
            int v = r[1];
            int w = r[2];
            
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;  // 시작점 1
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            
            int now = curr.to;
            int time = curr.cost;
            
            if (time > dist[now]) continue;
            
            for(Node next: graph[now]) {
                if (dist[next.to] > dist[now] + next.cost) {
                    dist[next.to] = dist[now] + next.cost;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
        
        for(int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }
}