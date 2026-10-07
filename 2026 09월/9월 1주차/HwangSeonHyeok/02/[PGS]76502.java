import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i<s.length(); i++){
            String rotateS = s.substring(i)+s.substring(0,i);
            boolean isRight = true;
            Stack<Character> stack = new Stack<>();
            for(char c : rotateS.toCharArray()){
                if(c=='('||c=='['||c=='{'){
                    stack.push(c);
                }else{
                    if(stack.isEmpty()){
                        isRight = false;
                        break;
                    }
                    char topChar = stack.pop();
                    if(c==')'&&topChar!='('){
                        isRight = false;
                        break;
                    }
                    if(c==']'&&topChar!='['){
                        isRight = false;
                        break;
                    }
                    if(c=='}'&&topChar!='{'){
                        isRight = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()){
                isRight = false;
            }
            if(isRight)answer++;
        }
        return answer;
    }
}