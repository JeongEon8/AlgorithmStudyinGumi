import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(scoville.length);
        for (int n : scoville) {
            pq.add(n);
        }
        
        int cnt = 0;
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            
            if (cur >= K) {
                break;
            }
            
            if (pq.isEmpty()) {
                return -1;
            }
            
            int cur2 = pq.poll();
            pq.add(cur + cur2 * 2);
            
            cnt++;
        }
        
        return cnt;
    }
}
