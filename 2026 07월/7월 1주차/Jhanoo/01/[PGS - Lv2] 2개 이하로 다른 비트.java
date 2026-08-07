import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        int n = numbers.length;
        long[] answer = new long[n];
        
        for (int i = 0; i < n; i++) {
            long num = numbers[i];
            
            if ((num & 1) == 0) {
                answer[i] = num + 1;
            } else {
                long lastZero = (~num) & (num + 1);
                answer[i] = num + lastZero - (lastZero >> 1);
            }
        }
        
        return answer;
    }
}
