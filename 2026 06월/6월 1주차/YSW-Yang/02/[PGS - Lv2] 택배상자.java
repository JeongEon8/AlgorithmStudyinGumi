import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack();
        int size = order.length;
        
        int index = 0;
        for(int i = 1; i <= size; i++){
            stack.push(i);
            while(!stack.isEmpty() && stack.peek() == order[index]){
                answer++;
                index++;
                stack.pop();
            }
        }
        
        return answer;
    }
}
