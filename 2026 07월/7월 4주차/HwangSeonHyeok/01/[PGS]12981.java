import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for(int i = 1; i<words.length;i++){
            String prev = words[i-1];
            String current = words[i];
            if((prev.charAt(prev.length()-1)!=current.charAt(0))||set.contains(current)){
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                return answer;
            }
            set.add(current);
        }
        
        return answer;
    }
}