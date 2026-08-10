import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        long[] facto = new long[n + 1];
        facto[0] = 1;
        facto[1] = 1;
        
        for (int num = 2; num <= n; num++) {
            facto[num] = facto[num - 1] * num;
        }
        
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        k--; // 1-based → 0-based

        int[] answer = new int[n];
        
        for (int idx = 0; idx < n; idx++) {
            long factorial = facto[n - 1 - idx];

            int index = (int) (k / factorial);
            k %= factorial;

            answer[idx] = numbers.remove(index);
        }
        
        
        return answer;
    }
}
