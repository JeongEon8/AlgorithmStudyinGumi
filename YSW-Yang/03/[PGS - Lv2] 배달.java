import java.util.*;
class Solution {
    public class Node implements Comparable<Node>{
        int to;
        int cost;
        
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other){
            return this.cost - other.cost;
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<Node>[] graph = new ArrayList[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        int[] distance = new int[N + 1];
        int INF = 100_000_000;
        Arrays.fill(distance, INF);
        distance[1] = 0;

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < road.length; i++){
            int from = road[i][0];
            int to = road[i][1];
            int cost = road[i][2];

            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }
        
        while(!pq.isEmpty()){
            Node current = pq.poll();
            int currNode = current.to;
            int currCost = current.cost;

            if(currCost > distance[currNode]){
                continue;
            }
            
            for(Node neighbor : graph[currNode]){
                if(distance[neighbor.to] > distance[currNode] + neighbor.cost){
                    distance[neighbor.to] = distance[currNode] + neighbor.cost;
                    pq.add(new Node(neighbor.to, distance[neighbor.to]));
                }
            }
        }

        for(int i = 1; i <= N; i++){
            if(distance[i] <= K){
                answer++;
            }
        }

        return answer;
    }
}
