import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : weights) {
            if (map.containsKey(num)) {
                answer += map.get(num);
            }
            
            if (num % 3 == 0 && map.containsKey(num * 2 / 3)) {
                answer += map.get(num * 2 / 3);
            }
            
            if (num % 2 == 0 && map.containsKey(num / 2)) {
                answer += map.get(num / 2);
            }
            
            if (num % 4 == 0 && map.containsKey(num * 3 / 4)) {
                answer += map.get(num * 3 / 4);
            }
            
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        return answer;
    }
}
