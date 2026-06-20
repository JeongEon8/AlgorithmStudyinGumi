import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        
        int[] answer = new int[n];
        List<Integer> nums = new ArrayList<>();
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            nums.add(i);
            fact *= i;
        }
        
        k--;
        for(int i = 0; i < n; i++) {
            fact /= (n - i);
            
            int idx = (int) (k / fact);
            answer[i] = nums.remove(idx);
            
            k %= fact;
        }
        
        return answer;
    }
    
}