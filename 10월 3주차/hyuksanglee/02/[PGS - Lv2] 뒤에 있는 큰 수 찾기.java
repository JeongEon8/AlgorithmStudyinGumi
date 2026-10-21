import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        
        int[] answer = new int[len];
        
        Stack<int[]> stack = new Stack();
        for(int i = 0; i<len; i++){
            int num = numbers[i];
            answer[i] = -1;
            while(!stack.isEmpty()){
                
                int[] data = stack.pop();
                if(data[1]<num){
                    answer[data[0]]=num;
                }else{
                    stack.push(data);
                    break;
                }
            }
            stack.push(new int[]{i,num});
        }
        
        return answer;
    }
}
