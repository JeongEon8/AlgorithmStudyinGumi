import java.util.*;

class Solution {
    public int solution(String name) {
        int n = name.length();
        int answer = 0;
        int move = n - 1;
        
        for(int i = 0; i < n; i++){
            int up = name.charAt(i) - 'A';
            int down = 'Z' - name.charAt(i) + 1;
            answer += Math.min(up, down);
        }
        
        for (int i = 0; i < n; i++) {
            int next = i + 1;

            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            int rightThenLeft = 2 * i + (n - next);
            int leftThenRight = i + 2 * (n - next);
            move = Math.min(move, Math.min(rightThenLeft, leftThenRight));
        }
        
        return answer + move;
    }
}
