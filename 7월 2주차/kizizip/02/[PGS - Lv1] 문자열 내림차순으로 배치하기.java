import java.util.*;

class Solution {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        
        StringBuilder sb = new StringBuilder(String.valueOf(chars));
        
        return sb.reverse().toString();
    }
}
