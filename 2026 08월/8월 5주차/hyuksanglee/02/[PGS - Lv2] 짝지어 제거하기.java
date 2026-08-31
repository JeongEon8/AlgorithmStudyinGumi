import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        Stack<Character> st = new Stack();
        for(char c : s.toCharArray()){
            if(st.isEmpty()){
                st.push(c);
            }else{
                if (st.peek() == c){
                    st.pop();
                }else{
                    st.push(c);
                }
            }
        }
        
        if(st.size()==0){
            answer = 1;
        }

       
        System.out.println("Hello Java");

        return answer;
    }
}
