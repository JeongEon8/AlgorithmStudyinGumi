import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> tree = new HashMap<>();
        int[] connected = new int[n];
        for(int[] wire: wires) {
            tree.computeIfAbsent(wire[0], k -> new ArrayList<Integer>()).add(wire[1]);
            tree.computeIfAbsent(wire[1], k -> new ArrayList<Integer>()).add(wire[0]);
        }
        for(int[] wire: wires) {
            Map<Integer, Boolean> set1 = new HashMap<>();
            Map<Integer, Boolean> set2 = new HashMap<>();    
            set1.put(wire[0], true);
            set2.put(wire[1], true);
            
            Queue<Integer> q = new LinkedList<>();
            q.add(wire[0]);
            while(q.size() > 0) {
                int node = q.poll();
                if(node != wire[1]) {
                    for(int next: tree.get(node)) {
                        if(set1.get(next) == null) {
                            set1.put(next, true);
                            q.add(next);
                        }
                    }
                }
            }
            
            q.add(wire[1]);
            while(q.size() > 0) {
                int node = q.poll();
                if(node != wire[0]) {
                    for(int next: tree.get(node)) {
                        if(set2.get(next) == null) {
                            set2.put(next, true);
                            q.add(next);
                        }
                    }
                }
            }
            answer = Math.min(answer, Math.abs(set2.size() - set1.size()));
            if(answer == 0) break;
        }        
        return answer;
    }
}
