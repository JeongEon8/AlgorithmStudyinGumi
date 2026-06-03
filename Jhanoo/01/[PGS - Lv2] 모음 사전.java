import java.util.*;

class Solution {
    
    static String[] alphabets = { "A", "E", "I", "O", "U" };
    static List<String> a = new ArrayList<>();
    
    public int solution(String word) {
        
        dfs("");
        
        return a.indexOf(word) + 1;
    }
    
    static void dfs(String current) {
        if (current.length() == 5) 
            return;
        
        for (String alphabet : alphabets) {
            String next = current + alphabet;
            a.add(next);
            dfs(next);
        }
    }
}
