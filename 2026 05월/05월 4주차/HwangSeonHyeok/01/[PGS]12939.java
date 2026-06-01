import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while(st.hasMoreTokens()){
            int current = Integer.parseInt(st.nextToken());
            max = Math.max(max,current);
            min = Math.min(min,current);
        }
        answer+= min+" "+max;
        return answer;
    }
}