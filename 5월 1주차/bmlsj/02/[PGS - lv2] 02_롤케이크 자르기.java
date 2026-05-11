import java.util.*;
class Solution {
    public int solution(int[] topping) {
        
        Map<Integer, Integer> right = new HashMap<>();
        Set<Integer> left = new HashSet<>();
        
        for (int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
        }
        
        int ans = 0;
        for(int i = 0; i < topping.length; i++) {
            
            int t = topping[i];
            
            // 왼쪽으로 이동
            left.add(t);
            
            // 오른쪽 개수 감소
            right.put(t, right.get(t) - 1);
            
            if (right.get(t) == 0) {
                right.remove(t);
            }
            
            if (left.size() == right.size()) {
                ans++;
            }
            
        }
        
        return ans;
    }
}