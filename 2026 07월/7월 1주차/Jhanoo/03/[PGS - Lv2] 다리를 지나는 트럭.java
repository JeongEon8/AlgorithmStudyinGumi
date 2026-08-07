import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> q = new ArrayDeque<>();
        
        int idx = 0;
        int t = 0;
        int curWeight = 0;
        
        while(idx < truck_weights.length) {
            t++;
            
            int[] cur = q.peek();
            
            if (cur != null && t - cur[1] == bridge_length) {
                cur = q.poll();
                curWeight -= cur[0];
            }
            
            if (curWeight + truck_weights[idx] <= weight) {
                curWeight += truck_weights[idx];
                q.offer(new int[] {truck_weights[idx++], t});
            }
        }
        
        return t + bridge_length;
    }
}
