import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int base = s / n;
        int remain = s % n;
        
        Arrays.fill(answer, base);
        
        for(int i = n - remain; i < n; i++) {
            answer[i]++;
        }
        
        if (s < n) return new int[]{-1};
        return answer;
    }
}