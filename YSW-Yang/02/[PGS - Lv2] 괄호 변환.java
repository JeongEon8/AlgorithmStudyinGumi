import java.util.*;
class Solution {
    public String solution(String p) {
        if(p.isEmpty()){
            return "";
        }
        
        int balance = 0;
        int splitIndex = 0;
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '('){
                balance++;
            }else{
                balance--;
            }
            
            if(balance == 0){
                splitIndex = i + 1;
                break;
            }
        }
        String u = p.substring(0, splitIndex);
        String v = p.substring(splitIndex);
        
        if(isCorrect(u)){
            return u + solution(v);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(solution(v));
        sb.append(')');
        
        for(int i = 1; i < u.length() - 1; i++){
            if(u.charAt(i) == '('){
                sb.append(')');
            }else{
                sb.append('(');
            }
        }
        
        return sb.toString();
    }
    
    public boolean isCorrect(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                count++;
            }else{
                count--;
            }
            
            if(count < 0){
                return false;
            }
        }
        
        return true;
    }
}
