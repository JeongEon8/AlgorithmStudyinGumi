import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, Node> map = new HashMap<>();
        int candidate = 0;
        int maxNode = 0;
        List<Integer> starts = new ArrayList<>();
        for(int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            
            map.computeIfAbsent(from, k -> new Node(from)).out.add(to); 
            map.computeIfAbsent(to, k -> new Node(to)).in.add(from);
            
            maxNode = Math.max(from, maxNode);
            maxNode = Math.max(to, maxNode);
            // in에는 얘를 가리키는 노드
            // out에는 얘가 가리키는 노드
            // from -> to
            starts.add(from);
        }
        boolean[] visited = new boolean[maxNode+1];
        
        for(int start: starts) {
            if(map.get(start).out.size() >= 2 && map.get(start).in.size() == 0) {
                candidate = start;
                answer[0] = candidate;
                break;
            }
        }
        for(int start: map.get(candidate).out) {
            if(visited[start] == false) {
                int cycleCnt = 0;
                Queue<Integer> q = new LinkedList<>();
                q.add(start);
                visited[start] = true;
                while(q.size() > 0) {
                    int cur = q.poll();
                    for(int next: map.get(cur).out) {
                        if(visited[next] == false) {
                            visited[next] = true;
                            q.add(next);
                        } else cycleCnt++;
                    }
                }
                switch(cycleCnt) {
                    case 0: answer[2]++;
                        break;
                    case 1: answer[1]++;
                        break;
                    case 2: answer[3]++;
                        break;
                }
            }
        }
        
        return answer;
    }
    
    public class Node {
        int num;
        List<Integer> in;
        List<Integer> out;
        
        public Node(int num) {
            this.num = num;
            this.in = new ArrayList<Integer>();
            this.out = new ArrayList<Integer>();
        }
    }
}


