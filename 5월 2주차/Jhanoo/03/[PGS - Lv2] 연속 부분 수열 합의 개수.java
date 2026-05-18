import java.util.*;

class Solution {
    public int solution(int[] elements) {
        // 1,000 * 1,000 = 1,000,000
        HashSet<Integer> s = new HashSet<>();
        
        int n = elements.length;
        for (int i = 0; i < n; i++) {
            for (int len = 1; len <= n; len++) {
                int sum = 0;
                for (int j = 0; j < len; j++) 
                    sum += elements[(i + j) % n];
                
                s.add(sum);
            }
        }
        
        return s.size();
    }
}
