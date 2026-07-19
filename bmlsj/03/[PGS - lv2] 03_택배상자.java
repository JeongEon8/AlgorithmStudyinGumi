
import java.util.*;

class Solution {

    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> st = new Stack<>();
        int idx = 0;
        int currBox = 1;

        for (int i = 0; i < order.length; i++) {
            int target = order[i];

            while (currBox <= target) {
                st.push(currBox++);
            }

            if (!st.isEmpty() && st.peek() == target) {
                // 만약 같다면
                st.pop();
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}
