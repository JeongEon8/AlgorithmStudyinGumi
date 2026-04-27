import java.util.*;

class Solution {
    public String solution(String s) {
        char[] str = s.toCharArray();
        boolean isFirst = true;
        
        for (int i = 0; i < str.length; i++) {
            char cur = str[i];
            
            if (cur == ' ') {
                isFirst = true;
                continue;
            }
            
            if (isFirst) {
                str[i] = Character.toUpperCase(cur);
                isFirst = false;
            } else {
                str[i] = Character.toLowerCase(cur);
            }
        }
        
        String answer = new String(str);
        return answer;
    }
}