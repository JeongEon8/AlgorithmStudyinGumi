import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Map<Integer, Integer> count = new HashMap<>();
        Arrays.sort(weights);
        
        long answer = 0;
        
        for (int w : weights) {
            answer += count.getOrDefault(w, 0);
            
            if (w % 2 == 0) {
                answer += count.getOrDefault(w / 2, 0);
            }
            if (w % 3 == 0) {
                answer += count.getOrDefault(w * 2 / 3, 0);
            }
            if (w % 4 == 0) {
                answer += count.getOrDefault(w * 3 / 4, 0);
            }
            
            count.put(w, count.getOrDefault(w, 0) + 1);
        }
        
        return answer;
    }
}
