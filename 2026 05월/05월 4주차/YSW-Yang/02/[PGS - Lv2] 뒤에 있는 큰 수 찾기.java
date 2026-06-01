import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int size = numbers.length;
        int[] answer = new int[size];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(answer, -1);
        
        for(int i = 0; i < size; i++){
            while(!stack.isEmpty()){
                if(numbers[stack.peek()] < numbers[i]){
                    answer[stack.pop()] = numbers[i];
                }else{
                    break;
                }
            }
            
            stack.push(i);
        }
        return answer;
    }
}
