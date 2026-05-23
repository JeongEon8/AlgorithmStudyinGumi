import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int n = elements.length;
        Set<Integer> uniqueSums = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            int currentSum = 0;
            for(int j = 0; j < n; j++){
                currentSum += elements[(i + j) % n];
                
                uniqueSums.add(currentSum);
            }
        }
        
        answer = uniqueSums.size();
        
        return answer;
    }
}
