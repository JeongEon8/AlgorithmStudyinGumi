import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(numbers[n - 1]);
        answer[n - 1] = -1;
        
        for (int i = n - 2; i >= 0; i--) {
            while (true) {
                int cur = stack.pop();
                
                if (numbers[i] < cur) {
                    answer[i] = cur;
                    stack.push(cur);
                    stack.push(numbers[i]);
                    break;
                }
                
                if (stack.isEmpty()) {
                    answer[i] = -1;
                    stack.push(numbers[i]);
                    break;
                }
            }
        }
        
        return answer;
    }
}
