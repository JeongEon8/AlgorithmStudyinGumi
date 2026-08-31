import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = Arrays.stream(diffs).max().getAsInt();
        int answer = right;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            long time = getTime(diffs, times, mid);
            
            if (time <= limit) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    public long getTime(int[] diffs, int[] times, int level) {
        long total = 0;
        
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                total += times[i];
            } else {
                int fail = diffs[i] - level;
                total += (long) (times[i - 1] + times[i]) * fail + times[i];
            }
        }
        
        return total;
    }
}
