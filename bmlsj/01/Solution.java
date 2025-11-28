import java.util.*;
class Solution {
    
    static List<Integer>[] graph;
    static int[] indegree;
    static int[] outdegree;
    static int cycleCnt;
    public int[] solution(int[][] edges) {

        int maxNode = -1;
        for (int[] e : edges) {
            maxNode = Math.max(maxNode, Math.max(e[0], e[1]));
        }
        
        graph = new ArrayList[maxNode + 1];
        indegree = new int[maxNode + 1];
        outdegree = new int[maxNode + 1];
        
        for(int i = 0; i <= maxNode; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for (int[] e : edges) {
            int from = e[0];
            int to = e[1];

            graph[from].add(to);

            outdegree[from]++;
            indegree[to]++;
        }
        
        // 시작 노드
        int startNode = findStartNode();

        int donut = 0;
        int bar = 0;
        int eight = 0;
        
        int[] visited = new int[maxNode + 1]; 
        int gId = 1;
        for(int next: graph[startNode]) {
            
            cycleCnt = 0;
            findCycle(next, gId, visited);
            gId++;
            
            if (cycleCnt == 0) bar++;
            else if (cycleCnt == 1) donut++;
            else if (cycleCnt == 2) eight++;
        }
        
       // System.out.println(bar + " " + donut + " " + eight);

        return new int[]{startNode, donut, bar, eight};
    }
    
    static void findCycle(int node, int id, int[] state) {
        
        state[node] = id;
        for(int next: graph[node]) {
            
            if (state[next] != id) {
                findCycle(next, id, state);
            } else { // 방문중이라면 사이클
                cycleCnt++;
            }
        }
    }
    
    static int findStartNode() {
        
        for(int i = 1; i <= outdegree.length; i++) {
            if (outdegree[i] >= 2 && indegree[i] == 0) {
                return i;
            }
        }
        return 0;
    }
}
