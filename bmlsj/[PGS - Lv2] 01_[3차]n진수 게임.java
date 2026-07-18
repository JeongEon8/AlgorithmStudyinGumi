import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int end = t * m;
        List<String> list = new ArrayList<>();
        for(int i = 0; i <= end; i++) {
            String change = Integer.toString(i, n).toUpperCase();
            for(char c: change.toCharArray()) {
                list.add(c + "");
            }
            
        } 
        
   
        for(int i = p - 1; i < list.size(); i += m) {
            answer += list.get(i);
            if (answer.length() == t) break;
        }
        
        return answer;
    }
}