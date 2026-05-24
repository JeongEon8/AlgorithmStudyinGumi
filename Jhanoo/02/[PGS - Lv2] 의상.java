import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> m = new HashMap<>();
        
        for (String[] c : clothes) {
            m.put(c[1], m.getOrDefault(c[1], 0) + 1);
        }
        
        int answer = 1;
        
        for (int count : m.values()) {
            answer *= count + 1;
        }
        
        return answer - 1;
    }
}
