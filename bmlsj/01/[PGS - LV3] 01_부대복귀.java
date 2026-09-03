import java.util.*;
class Solution {
    
    static List<Integer>[] graph;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        List<Integer> ans = new ArrayList<>();
        
        int max = -1;
        for (int[] road : roads) {
            max = Math.max(max, Math.max(road[0], road[1]));
        }
        
        graph = new ArrayList[max + 1];
        for(int i = 0; i <= max; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] road: roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        
        for(int source: sources) {
            ans.add(bfs(source, destination));
        }
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
    
    static int bfs(int source, int destination) {
        
        Queue<int[]> pq = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];
        
        visited[source] = true;
        pq.add(new int[]{source, 0});
        
        while(!pq.isEmpty()) {
            
            int[] curr = pq.poll();
            int area = curr[0];
            int cnt = curr[1];
            
            if (area == destination) {
                return cnt;
            }
            
            for (int next: graph[area]) {
                if (!visited[next]) {
                    visited[next] = true;
                    pq.add(new int[]{next, cnt + 1});
                }
            }            
            
        }
        
        return -1;
        
    }
}