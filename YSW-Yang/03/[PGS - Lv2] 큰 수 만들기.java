import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < number.length(); i++){
            if(stack.isEmpty()){
                stack.push(number.charAt(i));
            }else{
                while(!stack.isEmpty() && stack.peek() < number.charAt(i) && k > 0){
                    stack.pop();
                    k--;
                }
                stack.push(number.charAt(i));
            }
        }
        
        while(k-- > 0){
            stack.pop();
        }
        
        for(int i = 0; i < stack.size(); i++){
            sb.append(stack.get(i));
        }
        answer = sb.toString();
        
        return answer;
    }
}
