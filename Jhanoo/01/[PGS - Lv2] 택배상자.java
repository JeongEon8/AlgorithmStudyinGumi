import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        
        for (int box = 1; box <= order.length; box++) {
            stack.push(box);
            
            while(!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
                
                if (idx == order.length)
                    return idx;
            }
        }
        
        return idx;
    }
}
