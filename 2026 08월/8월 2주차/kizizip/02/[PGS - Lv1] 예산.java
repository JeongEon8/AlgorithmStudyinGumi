import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        int sum = 0;
        for (int i : d) {
            sum += i;
            if (sum > budget) {
                break;
            }
            answer++;
        }
        return answer;
    }
}
