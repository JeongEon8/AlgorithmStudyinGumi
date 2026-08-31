import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] == b[col - 1]) {
                return b[0] - a[0];
            }
            return a[col - 1] - b[col - 1];
        });
        
        int answer = 0;
        for (int i = row_begin; i <= row_end; i++) {
            int sum = 0;

            for (int num : data[i - 1]) {
                sum += num % i;
            }

            answer ^= sum;
        }
        
        return answer;
    }
}
